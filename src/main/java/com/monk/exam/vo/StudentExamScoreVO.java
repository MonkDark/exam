package com.monk.exam.vo;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * student_exam_score 
 * 学生考试成绩表
 *
 * @author monk
 * @since 2022-05-09 15:34:19
 */
@Data
@ApiModel(value="com-monk-exam-vo-StudentExamScoreVO")
public class StudentExamScoreVO implements Serializable {
     private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private Long id;

    
    /**
     * 考试编号
     */
    @ApiModelProperty(value = "考试编号")
    private Long examId;
    
    /**
     * 学生编号
     */
    @ApiModelProperty(value = "学生编号")
    private Long studentId;
    
    /**
     * 科目
     */
    @ApiModelProperty(value = "科目")
    private String course;
    
    /**
     * 考试成绩
     */
    @ApiModelProperty(value = "考试成绩")
    private Integer score;
    
    /**
     * 考试时间
     */
    @ApiModelProperty(value = "考试时间")
    private LocalDateTime examTime;
}