package com.monk.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * sys_user_role 
 * 后台用户角色表
 *
 * @author monk
 * @since 2022-04-26 11:02:10
 */
@Data
@ApiModel(value="后台用户角色表")
@TableName(value = "sys_user_role")
public class SysUserRole implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "ID")
    private Long id;
    
    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户ID")
    private Long userId;
    
    /**
     * 权限ID
     */
    @TableField(value = "role_id")
    @ApiModelProperty(value = "权限ID")
    private Long roleId;

    private static final long serialVersionUID = 1L;
}