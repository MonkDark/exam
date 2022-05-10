package com.monk.exam.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.*;
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
@ApiModel(value="考试表")
@TableName(value = "exam")
public class Exam implements Serializable {
    /**
     * 考试编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "考试编号")
    private Long id;
    
    /**
     * 考试介绍
     */
    @TableField(value = "description")
    @ApiModelProperty(value = "考试介绍")
    private String description;

    /**
     * 科目
     */
    @TableField(value = "course", condition = SqlCondition.LIKE)
    @ApiModelProperty(value = "科目")
    private String course;
    
    /**
     * 考试日期
     */
    @TableField(value = "exam_time")
    @ApiModelProperty(value = "考试日期")
    private LocalDateTime examTime;
    
    /**
     * 持续时长
     */
    @TableField(value = "total_time")
    @ApiModelProperty(value = "持续时长")
    private Integer totalTime;
    
    /**
     * 年级
     */
    @TableField(value = "grade")
    @ApiModelProperty(value = "年级")
    private String grade;
    
    /**
     * 学期
     */
    @TableField(value = "term")
    @ApiModelProperty(value = "学期")
    private String term;
    
    /**
     * 专业
     */
    @TableField(value = "major")
    @ApiModelProperty(value = "专业")
    private String major;
    
    /**
     * 学院
     */
    @TableField(value = "institute")
    @ApiModelProperty(value = "学院")
    private String institute;
    
    /**
     * 考试类型
     */
    @TableField(value = "type")
    @ApiModelProperty(value = "考试类型")
    private String type;
    
    /**
     * 考生须知
     */
    @TableField(value = "tips")
    @ApiModelProperty(value = "考生须知")
    private String tips;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value = "创建者")
    private String createBy;

    /**
     * 修改时间
     */
    @TableField(value = "edit_time", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime editTime;

    /**
     * 修改者
     */
    @TableField(value = "edit_by")
    @ApiModelProperty(value = "修改者")
    private String editBy;
    
    /**
     * 考试难度
     */
    @TableField(value = "level")
    @ApiModelProperty(value = "考试难度")
    private Object level;

    private static final long serialVersionUID = 1L;
}