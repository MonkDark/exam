package com.monk.exam.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * student_paper_answer 
 * 学生试卷答案表
 *
 * @author monk
 * @since 2022-05-04 14:12:43
 */
@Data
@ApiModel(value="com-monk-exam-vo-StudentPaperAnswerVO")
public class StudentPaperAnswerVO implements Serializable {
     private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private Long id;

    
    /**
     * 学生ID
     */
    @ApiModelProperty(value = "学生ID")
    private Long studentId;
    
    /**
     * 试卷ID
     */
    @ApiModelProperty(value = "试卷ID")
    private Long paperId;
    
    /**
     * 问题类型
     */
    @ApiModelProperty(value = "问题类型")
    private String questionType;
    
    /**
     * 问题ID
     */
    @ApiModelProperty(value = "问题ID")
    private Long questionId;
    
    /**
     * 学生答案
     */
    @ApiModelProperty(value = "学生答案")
    private String studentAnswer;
}