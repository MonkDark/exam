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
 * student 
 * 学生表
 *
 * @author monk
 * @since 2022-04-25 16:28:34
 */
@Data
@ApiModel(value="com-monk-exam-vo-StudentVO")
@TableName(value = "Student")
public class StudentVO implements Serializable {
     private static final long serialVersionUID = 1L;

    /**
     * 学号ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "学号ID")
    private Long id;

    
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;
    
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;
    

    
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String avatar;
    
    /**
     * 年级
     */
    @ApiModelProperty(value = "年级")
    private String grade;
    
    /**
     * 专业
     */
    @ApiModelProperty(value = "专业")
    private String major;
    
    /**
     * 班级
     */
    @ApiModelProperty(value = "班级")
    private String className;
    
    /**
     * 学院
     */
    @ApiModelProperty(value = "学院")
    private String institute;
    
    /**
     * 电话号码
     */
    @ApiModelProperty(value = "电话号码")
    private String phone;
    
    /**
     * 电子邮件
     */
    @ApiModelProperty(value = "电子邮件")
    private String email;
    
    /**
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后登录时间")
    private LocalDateTime lastLogin;
    
    /**
     * 状态(0:正常,1:锁定)
     */
    @ApiModelProperty(value = "状态(0:正常,1:锁定)")
    private Integer locked;
    
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
}