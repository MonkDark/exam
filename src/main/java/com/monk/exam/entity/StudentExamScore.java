package com.monk.exam.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * student_exam_score 
 * 学生考试成绩表
 *
 * @author monk
 * @since 2022-05-09 15:34:19
 */
@Data
@Accessors(chain = true)
@ApiModel(value="学生考试成绩表")
@TableName(value = "student_exam_score")
public class StudentExamScore implements Serializable {
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

    private static final long serialVersionUID = 1L;
}