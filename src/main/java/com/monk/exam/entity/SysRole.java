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
 * sys_role 
 * 后台用户角色表
 *
 * @author monk
 * @since 2022-04-25 15:35:24
 */
@Data
@ApiModel(value="后台用户角色表")
@TableName(value = "sys_role")
public class SysRole implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "ID")
    private Long id;
    
    /**
     * 角色名称
     */
    @TableField(value = "name")
    @ApiModelProperty(value = "角色名称")
    private String name;
    
    /**
     * 角色代码
     */
    @TableField(value = "code")
    @ApiModelProperty(value = "角色代码")
    private String code;
    
    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty(value = "备注")
    private String remark;

    private static final long serialVersionUID = 1L;
}