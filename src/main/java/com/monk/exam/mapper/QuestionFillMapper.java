package com.monk.exam.mapper;

import com.monk.exam.common.MyBaseMapper;
import com.monk.exam.entity.QuestionFill;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * question_fill 表数据库访问层
 * 填空题表
 *
 * @author monk
 * @since 2022-04-26 16:49:26
 */
public interface QuestionFillMapper extends MyBaseMapper<QuestionFill> {
    /**
     * @description 根据paperId获取
     * @param paperId 试卷ID
     * @return List<QuestionFill> QuestionFillList
     */
    @Select("select * from question_fill where id in(select question_id from paper_question where paper_id=#{paperId} and question_type='3')")
    List<QuestionFill> selectAllByPaperId(Long paperId);
}