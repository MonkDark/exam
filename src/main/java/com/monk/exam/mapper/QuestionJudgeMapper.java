package com.monk.exam.mapper;

import com.monk.exam.common.MyBaseMapper;
import com.monk.exam.entity.QuestionJudge;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * question_judge 表数据库访问层
 * 判断题表
 *
 * @author monk
 * @since 2022-04-26 16:48:35
 */
public interface QuestionJudgeMapper extends MyBaseMapper<QuestionJudge> {
    /**
     * @description 根据paperId获取
     * @param paperId 试卷ID
     * @return List<QuestionJudge> QuestionJudgeList
     */
    @Select("select * from question_judge where id in(select question_id from paper_question where paper_id=#{paperId} and question_type='2')")
    List<QuestionJudge> selectAllByPaperId(Long paperId);
}