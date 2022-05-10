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
 * student 
 * 学生表
 *
 * @author monk
 * @since 2022-04-25 16:28:34
 */
@Data
@ApiModel(value="com-monk-exam-dto-StudentDTO")
@TableName(value = "Student")
public class StudentDTO implements Serializable {
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
    @TableField(value = "name")
    @ApiModelProperty(value = "姓名")
    private String name;
    
    /**
     * 性别
     */
    @TableField(value = "sex")
    @ApiModelProperty(value = "性别")
    private String sex;
    
    /**
     * 密码
     */
    @TableField(value = "password")
    @ApiModelProperty(value = "密码")
    private String password;
    
    /**
     * 头像
     */
    @TableField(value = "avatar")
    @ApiModelProperty(value = "头像")
    private String avatar;
    
    /**
     * 年级
     */
    @TableField(value = "grade")
    @ApiModelProperty(value = "年级")
    private String grade;
    
    /**
     * 专业
     */
    @TableField(value = "major")
    @ApiModelProperty(value = "专业")
    private String major;
    
    /**
     * 班级
     */
    @TableField(value = "class_name")
    @ApiModelProperty(value = "班级")
    private String className;
    
    /**
     * 学院
     */
    @TableField(value = "institute")
    @ApiModelProperty(value = "学院")
    private String institute;
    
    /**
     * 电话号码
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "电话号码")
    private String phone;
    
    /**
     * 电子邮件
     */
    @TableField(value = "email")
    @ApiModelProperty(value = "电子邮件")
    private String email;
    
    /**
     * 最后登录时间
     */
    @TableField(value = "last_login")
    @ApiModelProperty(value = "最后登录时间")
    private LocalDateTime lastLogin;
    
    /**
     * 状态(0:正常,1:锁定)
     */
    @TableField(value = "locked")
    @ApiModelProperty(value = "状态(0:正常,1:锁定)")
    private Integer locked;
    
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