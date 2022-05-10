package com.monk.exam.dto;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="com-monk-exam-dto-ExamDTO")
@TableName(value = "Exam")
public class ExamDTO implements Serializable {
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
    @TableField(value = "description")
    @ApiModelProperty(value = "考试介绍")
    private String description;
    
    /**
     * 科目
     */
    @TableField(value = "course")
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
    @TableField(value = "create_time")
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
    @TableField(value = "edit_time")
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
     * 设置每页显示条数
     */
    @TableField(value = "pageSize")
    @ApiModelProperty(value = "设置每页显示条数")
    private Integer pageSize;
    
    /**
     * 当前页
     */
    @TableField(value = "currentPage")
    @ApiModelProperty(value = "当前页")
    private Integer currentPage;

}