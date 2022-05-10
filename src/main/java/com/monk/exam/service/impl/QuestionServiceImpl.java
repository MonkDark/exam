package com.monk.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monk.exam.common.WrapperUtil;
import com.monk.exam.dto.QuestionDTO;
import com.monk.exam.entity.Question;
import com.monk.exam.mapper.QuestionMapper;
import com.monk.exam.service.QuestionService;
import com.monk.exam.vo.QuestionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * question 题库服务接口
 * 题库(选择表、判断表、填空题表)
 *
 * @author monk
 * @since 2022-04-26 16:49:26
 */
@Transactional(rollbackFor = Exception.class)
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionMapper questionMapper;

    /**
     * @description 多表分页查询所有数据
     *
     * @param page 查询设置
     * @param paramDto 查询条件
     * @return IPage<QuestionVO>  所有数据
     */
    @Override
    public <E extends IPage<QuestionVO>> E pageMultiTable(E page, QuestionDTO paramDto) {
        //查询条件复制
        Question question = new Question();
        BeanUtils.copyProperties(paramDto, question);
        // 使用工具类拼接查询条件并开启字段模糊查询
        // 字段需设置@TableField(ondition = SqlCondition.LIKE)
        QueryWrapper<Question> queryWrapper = WrapperUtil.entity2Wrapper(question,true);
        return questionMapper.selectPageMultiTable(page, queryWrapper);
    }
}