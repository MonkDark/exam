package com.monk.exam.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * question
 * 题库(选择表、判断表、填空题表)
 *
 * @author monk
 * @since 2022-04-26 16:50:19
 */
@Data
@ApiModel(value="com-monk-exam-vo-QuestionVO")
public class QuestionVO implements Serializable {
     private static final long serialVersionUID = 1L;

    /**
     * 试题编号
     */
    @ApiModelProperty(value = "试题编号")
    private Long id;

    
    /**
     * 科目
     */
    @ApiModelProperty(value = "科目")
    private String course;
    
    /**
     * 问题题目
     */
    @ApiModelProperty(value = "问题题目")
    private String question;
    
    /**
     * 选项A
     */
    @ApiModelProperty(value = "选项A")
    private String optionA;
    
    /**
     * 选项B
     */
    @ApiModelProperty(value = "选项B")
    private String optionB;
    
    /**
     * 选项C
     */
    @ApiModelProperty(value = "选项C")
    private String optionC;
    
    /**
     * 选项D
     */
    @ApiModelProperty(value = "选项D")
    private String optionD;
    
    /**
     * 正确答案
     */
    @ApiModelProperty(value = "正确答案")
    private String answer;
    
    /**
     * 题目解析
     */
    @ApiModelProperty(value = "题目解析")
    private String analysis;
    
    /**
     * 分数
     */
    @ApiModelProperty(value = "分数")
    private Integer score;
    
    /**
     * 所属章节
     */
    @ApiModelProperty(value = "所属章节")
    private String section;
    
    /**
     * 难度等级
     */
    @ApiModelProperty(value = "难度等级")
    private Integer level;

    /**
     * 试题类型
     */
    @ApiModelProperty(value = "试题类型")
    private String type;
}