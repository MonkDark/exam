package com.monk.exam.entity;

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
 * student_paper_answer 
 * 学生试卷答案表
 *
 * @author monk
 * @since 2022-05-04 14:12:43
 */
@Data
@Accessors(chain = true)
@ApiModel(value="学生试卷答案表")
@TableName(value = "student_paper_answer")
public class StudentPaperAnswer implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "ID")
    private Long id;
    
    /**
     * 学生ID
     */
    @TableField(value = "student_id")
    @ApiModelProperty(value = "学生ID")
    private Long studentId;
    
    /**
     * 试卷ID
     */
    @TableField(value = "paper_id")
    @ApiModelProperty(value = "试卷ID")
    private Long paperId;
    
    /**
     * 问题类型
     */
    @TableField(value = "question_type")
    @ApiModelProperty(value = "问题类型")
    private String questionType;
    
    /**
     * 问题ID
     */
    @TableField(value = "question_id")
    @ApiModelProperty(value = "问题ID")
    private Long questionId;
    
    /**
     * 学生答案
     */
    @TableField(value = "student_answer")
    @ApiModelProperty(value = "学生答案")
    private String studentAnswer;

    private static final long serialVersionUID = 1L;
}