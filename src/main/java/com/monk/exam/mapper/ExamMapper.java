package com.monk.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.monk.exam.entity.Exam;
import com.monk.exam.vo.ExamVO;
import com.monk.exam.vo.PaperVO;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * exam 表数据库访问层
 * 考试表
 *
 * @author monk
 * @since 2022-04-28 15:20:08
 */
public interface ExamMapper extends BaseMapper<Exam> {
    /**
     * @param id 主键
     * @return ExamVO
     * @description 通过主键查询单条数据
     */
    @Select("select * from exam where id=#{id}")
    // 关联查询
    @Results({
            @Result(column="id",property="id",id=true),
            // 返回paper
            @Result(column = "id", property = "paper", javaType = PaperVO.class,
                    one = @One(
                            select = "com.monk.exam.mapper.PaperMapper.selectByExamId"
                    )
            )
    })
    ExamVO selectByIdMultiTable(Long id);

}