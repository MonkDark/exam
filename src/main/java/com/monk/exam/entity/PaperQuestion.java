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
 * paper_question 
 * 试卷管理表
 *
 * @author monk
 * @since 2022-04-28 19:57:32
 */
@Data
@Accessors(chain = true)
@ApiModel(value="试卷管理表")
@TableName(value = "paper_question")
public class PaperQuestion implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "ID")
    private Long id;
    
    /**
     * 试卷ID
     */
    @TableField(value = "paper_id")
    @ApiModelProperty(value = "试卷ID")
    private Long paperId;
    
    /**
     * 题目类型
     */
    @TableField(value = "question_type")
    @ApiModelProperty(value = "题目类型")
    private String questionType;
    
    /**
     * 题目ID
     */
    @TableField(value = "question_id")
    @ApiModelProperty(value = "题目ID")
    private Long questionId;

    private static final long serialVersionUID = 1L;
}