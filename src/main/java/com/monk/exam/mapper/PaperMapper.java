package com.monk.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.monk.exam.entity.Paper;
import com.monk.exam.vo.PaperVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * paper 表数据库访问层
 * 试卷表
 *
 * @author monk
 * @since 2022-04-28 16:04:16
 */
public interface PaperMapper extends BaseMapper<Paper> {
    /**
     * @description 根据examID获取
     * @param examId 考试ID
     * @return PaperVO 试卷VO类
     */
    @Select("select * from paper where id in(select paper_id from exam_paper where exam_id=#{examId})")
    // 关联查询
    @Results({
            @Result(column="id",property="id",id=true),
            @Result(column = "id", property = "questionChoices", javaType = List.class,
                    many = @Many(
                            select = "com.monk.exam.mapper.QuestionChoiceMapper.selectAllByPaperId"
                    )
            ),
            @Result(column = "id", property = "questionJudges", javaType = List.class,
                    many = @Many(
                            select = "com.monk.exam.mapper.QuestionJudgeMapper.selectAllByPaperId"
                    )
            ),
            @Result(column = "id", property = "questionFills", javaType = List.class,
                    many = @Many(
                            select = "com.monk.exam.mapper.QuestionFillMapper.selectAllByPaperId"
                    )
            )
    })
    PaperVO selectByExamId(Long examId);
}