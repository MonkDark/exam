package com.monk.exam.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * question_judge 
 * 判断题表
 *
 * @author monk
 * @since 2022-04-26 16:48:35
 */
@Data
@ApiModel(value="com-monk-exam-vo-QuestionJudgeVO")
@TableName(value = "QuestionJudge")
public class QuestionJudgeVO implements Serializable {
     private static final long serialVersionUID = 1L;

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
     * 试题内容
     */
    @TableField(value = "question")
    @ApiModelProperty(value = "试题内容")
    private String question;
    
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
     * 难度等级
     */
    @TableField(value = "level")
    @ApiModelProperty(value = "难度等级")
    private Integer level;
    
    /**
     * 所属章节
     */
    @TableField(value = "section")
    @ApiModelProperty(value = "所属章节")
    private String section;
}