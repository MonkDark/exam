package com.monk.exam.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.monk.exam.entity.Question;
import com.monk.exam.vo.QuestionVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * question 题库数据库访问层
 * 题库(选择表、判断表、填空题表)
 *
 * @author monk
 * @since 2022-04-26 16:49:25
 */
public interface QuestionMapper extends BaseMapper<Question> {
    @Select("select * from (" +
            "select id,course,question,answer,analysis,score,section,level,option_a,option_b,option_c,option_d, 'choice' as type from question_choice " +
            "union select id,course,question,answer,analysis,score,section,level,null,null,null,null, 'judge' as type from question_judge " +
            "union select id,course,question,answer,analysis,score,section,level,null,null,null,null, 'fill' as type from question_fill" +
            ") temp ${ew.customSqlSegment}")
    <P extends IPage<QuestionVO>> P selectPageMultiTable(P page, @Param(Constants.WRAPPER) Wrapper<Question> queryWrapper);
}