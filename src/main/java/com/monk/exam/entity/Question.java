package com.monk.exam.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * question
 * 题库(选择表、判断表、填空题表)
 *
 * @author monk
 * @since 2022-04-26 16:49:25
 */
@Data
@ApiModel(value="题库")
@TableName(value = "question")
public class Question implements Serializable {
    /**
     * 试题编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "试题编号")
    private Long id;
    
    /**
     * 科目
     */
    @TableField(value = "course")
    @ApiModelProperty(value = "科目")
    private String course;
    
    /**
     * 问题题目
     */
    @TableField(value = "question",condition = SqlCondition.LIKE)
    @ApiModelProperty(value = "问题题目")
    private String question;
    
    /**
     * 选项A
     */
    @TableField(value = "option_a")
    @ApiModelProperty(value = "选项A")
    private String optionA;
    
    /**
     * 选项B
     */
    @TableField(value = "option_b")
    @ApiModelProperty(value = "选项B")
    private String optionB;
    
    /**
     * 选项C
     */
    @TableField(value = "option_c")
    @ApiModelProperty(value = "选项C")
    private String optionC;
    
    /**
     * 选项D
     */
    @TableField(value = "option_d")
    @ApiModelProperty(value = "选项D")
    private String optionD;
    
    /**
     * 正确答案
     */
    @TableField(value = "answer")
    @ApiModelProperty(value = "正确答案")
    private String answer;
    
    /**
     * 题目解析
     */
    @TableField(value = "analysis")
    @ApiModelProperty(value = "题目解析")
    private String analysis;
    
    /**
     * 分数
     */
    @TableField(value = "score")
    @ApiModelProperty(value = "分数")
    private Integer score;
    
    /**
     * 所属章节
     */
    @TableField(value = "section")
    @ApiModelProperty(value = "所属章节")
    private String section;
    
    /**
     * 难度等级
     */
    @TableField(value = "level")
    @ApiModelProperty(value = "难度等级")
    private Integer level;

    private static final long serialVersionUID = 1L;
}