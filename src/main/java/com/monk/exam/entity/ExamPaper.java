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
 * exam_paper 
 * 考试试卷表
 *
 * @author monk
 * @since 2022-05-02 17:22:07
 */
@Data
@Accessors(chain = true)
@ApiModel(value="考试试卷表")
@TableName(value = "exam_paper")
public class ExamPaper implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "ID")
    private Long id;
    
    /**
     * 考试编号
     */
    @TableField(value = "exam_id")
    @ApiModelProperty(value = "考试编号")
    private Long examId;
    
    /**
     * 试卷编号
     */
    @TableField(value = "paper_id")
    @ApiModelProperty(value = "试卷编号")
    private Long paperId;

    private static final long serialVersionUID = 1L;
}