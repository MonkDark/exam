package com.monk.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.monk.exam.common.Result;
import com.monk.exam.dto.ExamDTO;
import com.monk.exam.entity.*;
import com.monk.exam.mapper.*;
import com.monk.exam.service.ExamService;
import com.monk.exam.vo.ExamVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * exam 表服务实现类
 * 考试表
 *
 * @author monk
 * @since 2022-04-28 15:01:58
 */
@Transactional(rollbackFor = Exception.class)
@Service("examService")
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {
    @Resource
    private ExamMapper examMapper;
    @Resource
    private PaperMapper paperMapper;
    @Resource
    private ExamPaperMapper examPaperMapper;
    @Resource
    private QuestionChoiceMapper questionChoiceMapper;
    @Resource
    private QuestionJudgeMapper questionJudgeMapper;
    @Resource
    private QuestionFillMapper questionFillMapper;
    @Resource
    private PaperQuestionMapper paperQuestionMapper;

    /**
     * @param paramDto DTO 实体对象
     * @return Result<?> 封装结果类
     * @description 新增数据, 多表
     */
    @Override
    public Result<?> saveMultiTable(ExamDTO paramDto) {
        try {
            // 添加exam数据
            Exam exam = new Exam();
            BeanUtils.copyProperties(paramDto, exam);
            if (!this.save(exam)) {
                throw new Exception("添加exam数据失败！");
            }
            // 添加paper数据
            Paper paper = new Paper();
            BeanUtils.copyProperties(paramDto, paper);
            if (!SqlHelper.retBool(paperMapper.insert(paper))) {
                throw new Exception("添加paper数据失败！");
            }
            // 添加exam_paper关联
            ExamPaper examPaper = new ExamPaper().setExamId(exam.getId()).setPaperId(paper.getId());
            if (!SqlHelper.retBool(examPaperMapper.insert(examPaper))) {
                throw new Exception("添加exam_paper数据失败！");
            }
            // 组卷部分
            // 选题
            List<QuestionChoice> questionChoices = questionChoiceMapper.selectList(new LambdaQueryWrapper<QuestionChoice>()
                    .select(QuestionChoice::getId).last("order by RAND() limit " + paper.getChoiceQuestionNumber()));
            List<QuestionJudge> questionJudges = questionJudgeMapper.selectList(new LambdaQueryWrapper<QuestionJudge>()
                    .select(QuestionJudge::getId).last("order by RAND() limit " + paper.getJudgeQuestionNumber()));
            List<QuestionFill> questionFills = questionFillMapper.selectList(new LambdaQueryWrapper<QuestionFill>()
                    .select(QuestionFill::getId).last("order by RAND() limit " + paper.getFillQuestionNumber()));
            // 将paper_question关联信息添加到List<PaperQuestion>
            Long paperID = paper.getId();
            List<PaperQuestion> paperQuestions = new ArrayList<>();
            questionChoices.forEach(questionChoice -> paperQuestions.add(new PaperQuestion()
                    .setPaperId(paperID)
                    .setQuestionType("1")
                    .setQuestionId(questionChoice.getId())));
            questionJudges.forEach(questionJudge -> paperQuestions.add(new PaperQuestion()
                    .setPaperId(paperID)
                    .setQuestionType("2")
                    .setQuestionId(questionJudge.getId())));
            questionFills.forEach(questionFill -> paperQuestions.add(new PaperQuestion()
                    .setPaperId(paperID)
                    .setQuestionType("3")
                    .setQuestionId(questionFill.getId())));
            // 添加paper_question关联信息
            if (paperQuestionMapper.insertBatchSomeColumn(paperQuestions) != paperQuestions.size()) {
                throw new Exception("批量添加paperQuestion数据失败！");
            }
            // 封装返回结果
            return Result.success("添加考试数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            // @Transactional和try catch捕获异常会让注解失效
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error("添加考试数据失败！");
        }
    }

    /**
     * @param id 主键
     * @return ExamVO
     * @description 通过主键查询单条数据
     */
    @Override
    public ExamVO getByIdMultiTable(Long id) {
        return examMapper.selectByIdMultiTable(id);
    }
}