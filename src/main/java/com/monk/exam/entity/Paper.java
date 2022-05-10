package com.monk.exam.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * paper 
 * 试卷表
 *
 * @author monk
 * @since 2022-04-28 16:04:16
 */
@Data
@ApiModel(value="试卷表")
@TableName(value = "paper")
public class Paper implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "ID")
    private Long id;
    
    /**
     * 科目
     */
    @TableField(value = "course")
    @ApiModelProperty(value = "科目")
    private String course;
    
    /**
     * 试卷描述
     */
    @TableField(value = "description")
    @ApiModelProperty(value = "试卷描述")
    private String description;
    
    /**
     * 试卷难度
     */
    @TableField(value = "level")
    @ApiModelProperty(value = "试卷难度")
    private Object level;
    
    /**
     * 试卷类型(exam/test)
     */
    @TableField(value = "type")
    @ApiModelProperty(value = "试卷类型(exam/test)")
    private String type;
    
    /**
     * 选择题数量
     */
    @TableField(value = "choice_question_number")
    @ApiModelProperty(value = "选择题数量")
    private Integer choiceQuestionNumber;
    
    /**
     * 判断题数量
     */
    @TableField(value = "judge_question_number")
    @ApiModelProperty(value = "判断题数量")
    private Integer judgeQuestionNumber;
    
    /**
     * 填空题数量
     */
    @TableField(value = "fill_question_number")
    @ApiModelProperty(value = "填空题数量")
    private Integer fillQuestionNumber;
    
    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
    
    /**
     * 创建者
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value = "创建者")
    private String createBy;

    private static final long serialVersionUID = 1L;
}