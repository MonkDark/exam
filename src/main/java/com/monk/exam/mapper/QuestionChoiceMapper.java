package com.monk.exam.mapper;

import com.monk.exam.common.MyBaseMapper;
import com.monk.exam.entity.QuestionChoice;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * question_choice 表数据库访问层
 * 选择题表
 *
 * @author monk
 * @since 2022-04-26 16:49:25
 */
public interface QuestionChoiceMapper extends MyBaseMapper<QuestionChoice> {
    /**
     * @description 根据paperId获取
     * @param paperId 试卷ID
     * @return List<QuestionChoice> QuestionChoiceList
     */
    @Select("select * from question_choice where id in(select question_id from paper_question where paper_id=#{paperId} and question_type='1')")
    List<QuestionChoice> selectAllByPaperId(Long paperId);
}