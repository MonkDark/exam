package com.monk.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monk.exam.mapper.StudentPaperAnswerMapper;
import com.monk.exam.entity.StudentPaperAnswer;
import com.monk.exam.service.StudentPaperAnswerService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * student_paper_answer 表服务实现类
 * 学生试卷答案表
 *
 * @author monk
 * @since 2022-05-04 14:12:43
 */
@Transactional(rollbackFor = Exception.class)
@Service("studentPaperAnswerService")
public class StudentPaperAnswerServiceImpl extends ServiceImpl<StudentPaperAnswerMapper, StudentPaperAnswer> implements StudentPaperAnswerService {
    @Resource
    private StudentPaperAnswerMapper studentPaperAnswerMapper;

    /**
     * @param studentPaperAnswerList 实体对象List
     * @return 新增/修改结果
     * @description 批量新增/修改数据
     */
    @Override
    public boolean mysqlInsertOrUpdateBath(List<StudentPaperAnswer> studentPaperAnswerList) {
        try {
            if (studentPaperAnswerMapper.mysqlInsertOrUpdateBath(studentPaperAnswerList) != studentPaperAnswerList.size())
                throw new Exception("批量新增/修改StudentPaperAnswer失败");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            // @Transactional和try catch捕获异常会让注解失效
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }
}