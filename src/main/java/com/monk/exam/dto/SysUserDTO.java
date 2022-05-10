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
 * sys_user 
 * 后台用户表
 *
 * @author monk
 * @since 2022-04-24 11:43:01
 */
@Data
@ApiModel(value="com-monk-exam-dto-SysUserDTO")
@TableName(value = "SysUser")
public class SysUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "ID")
    private Long id;


    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
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

    /**
     * 权限代码
     */
    @TableField(value = "code")
    @ApiModelProperty(value = "权限代码")
    private String code;
}