package com.monk.exam.entity;

import java.time.LocalDateTime;

import cn.hutool.core.annotation.PropIgnore;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * sys_user 
 * 后台用户表
 *
 * @author monk
 * @since 2022-04-24 11:43:01
 */
@Data
@ApiModel(value="后台用户表")
@TableName(value = "sys_user")
public class SysUser implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "ID")
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username", condition = SqlCondition.LIKE)
    @ApiModelProperty(value = "用户名")
    private String username;
    
    /**
     * 密码,Bean拷贝时忽略该属性
     */
    @PropIgnore
    @TableField(value = "password", select = false)
    @ApiModelProperty(value = "密码")
    private String password;
    
    /**
     * 头像地址
     */
    @TableField(value = "avatar")
    @ApiModelProperty(value = "头像地址")
    private String avatar;
    
    /**
     * 性别
     */
    @TableField(value = "sex")
    @ApiModelProperty(value = "性别")
    private String sex;
    
    /**
     * 联系方式
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "联系方式")
    private String phone;
    
    /**
     * 邮箱地址
     */
    @TableField(value = "email")
    @ApiModelProperty(value = "邮箱地址")
    private String email;

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

    private static final long serialVersionUID = 1L;
}