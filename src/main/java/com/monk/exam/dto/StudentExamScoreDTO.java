package com.monk.exam.dto;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import com.monk.exam.entity.StudentExamScore;
import com.monk.exam.common.DTOConvert;
import org.springframework.beans.BeanUtils;

/**
 * student_exam_score 
 * 学生考试成绩表
 *
 * @author monk
 * @since 2022-05-09 15:34:19
 */
@Data
@ApiModel(value="com-monk-exam-dto-StudentExamScoreDTO")
@TableName(value = "StudentExamScore")
public class StudentExamScoreDTO implements Serializable {
     private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "ID")
    private Long id;

    
    /**
     * 考试编号
     */
    @TableField(value = "exam_id")
    @ApiModelProperty(value = "考试编号")
    private Long examId;
    
    /**
     * 学生编号
     */
    @TableField(value = "student_id")
    @ApiModelProperty(value = "学生编号")
    private Long studentId;
    
    /**
     * 科目
     */
    @TableField(value = "course")
    @ApiModelProperty(value = "科目")
    private String course;
    
    /**
     * 考试成绩
     */
    @TableField(value = "score")
    @ApiModelProperty(value = "考试成绩")
    private Integer score;
    
    /**
     * 考试时间
     */
    @TableField(value = "exam_time")
    @ApiModelProperty(value = "考试时间")
    private LocalDateTime examTime;

    /**
     * 设置每页显示条数
     */
    @TableField(value = "pageSize")
    @ApiModelProperty(value = "设置每页显示条数")
    private Integer pageSize;
    
    /**
     * 当前页
     */
    @TableField(value = "currentPage")
    @ApiModelProperty(value = "当前页")
    private Integer currentPage;

    /**
     * DTO转换类
     */
    private static class StudentExamScoreDTOConvert implements DTOConvert<StudentExamScoreDTO,StudentExamScore> {
        @Override
        public StudentExamScore convert(StudentExamScoreDTO studentExamScoreDTO) {
            StudentExamScore studentExamScore = new StudentExamScore();
            BeanUtils.copyProperties(studentExamScoreDTO,studentExamScore);
            return studentExamScore;
        }
    }

    /**
     * DTO转换方法
     */
    public StudentExamScore convertToStudentExamScore(){
        StudentExamScoreDTOConvert studentExamScoreDTOConvert = new StudentExamScoreDTOConvert();
        return studentExamScoreDTOConvert.convert(this);
    }
}