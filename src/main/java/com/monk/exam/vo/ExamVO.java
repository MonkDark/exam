package com.monk.exam.vo;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * exam 
 * 考试表
 *
 * @author monk
 * @since 2022-04-28 15:20:08
 */
@Data
@ApiModel(value="com-monk-exam-vo-ExamVO")
@TableName(value = "Exam")
public class ExamVO implements Serializable {
     private static final long serialVersionUID = 1L;

    /**
     * 考试编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "考试编号")
    private Long id;

    
    /**
     * 考试介绍
     */
    @ApiModelProperty(value = "考试介绍")
    private String description;
    
    /**
     * 科目
     */
    @ApiModelProperty(value = "科目")
    private String course;
    
    /**
     * 考试日期
     */
    @ApiModelProperty(value = "考试日期")
    private LocalDateTime examTime;
    
    /**
     * 持续时长
     */
    @ApiModelProperty(value = "持续时长")
    private Integer totalTime;
    
    /**
     * 年级
     */
    @ApiModelProperty(value = "年级")
    private String grade;
    
    /**
     * 学期
     */
    @ApiModelProperty(value = "学期")
    private String term;
    
    /**
     * 专业
     */
    @ApiModelProperty(value = "专业")
    private String major;
    
    /**
     * 学院
     */
    @ApiModelProperty(value = "学院")
    private String institute;
    
    /**
     * 考试类型
     */
    @ApiModelProperty(value = "考试类型")
    private String type;
    
    /**
     * 考生须知
     */
    @ApiModelProperty(value = "考生须知")
    private String tips;
    
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
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime editTime;
    
    /**
     * 修改者
     */
    @ApiModelProperty(value = "修改者")
    private String editBy;
    
    /**
     * 考试难度
     */
    @ApiModelProperty(value = "考试难度")
    private Object level;

    /**
     * 关联试卷
     */
    @ApiModelProperty(value = "关联试卷")
    private PaperVO paper;
}