package com.monk.exam.vo;

import java.time.LocalDateTime;

import com.monk.exam.entity.QuestionChoice;
import com.monk.exam.entity.QuestionFill;
import com.monk.exam.entity.QuestionJudge;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * paper
 * 试卷表
 *
 * @author monk
 * @since 2022-05-02 16:10:00
 */
@Data
@ApiModel(value = "com-monk-exam-vo-PaperVO")
public class PaperVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private Long id;


    /**
     * 科目
     */
    @ApiModelProperty(value = "科目")
    private String course;

    /**
     * 试卷描述
     */
    @ApiModelProperty(value = "试卷描述")
    private String description;

    /**
     * 试卷难度
     */
    @ApiModelProperty(value = "试卷难度")
    private Object level;

    /**
     * 试卷类型(exam/test)
     */
    @ApiModelProperty(value = "试卷类型(exam/test)")
    private String type;

    /**
     * 选择题数量
     */
    @ApiModelProperty(value = "选择题数量")
    private Integer choiceQuestionNumber;

    /**
     * 判断题数量
     */
    @ApiModelProperty(value = "判断题数量")
    private Integer judgeQuestionNumber;

    /**
     * 填空题数量
     */
    @ApiModelProperty(value = "填空题数量")
    private Integer fillQuestionNumber;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private String createBy;

    /**
     * 选择题
     */
    @ApiModelProperty(value = "选择题")
    private List<QuestionChoice> questionChoices;

    /**
     * 判断题
     */
    @ApiModelProperty(value = "判断题")
    private List<QuestionJudge> questionJudges;
    /**
     * 填空题
     */
    @ApiModelProperty(value = "填空题")
    private List<QuestionFill> questionFills;
}