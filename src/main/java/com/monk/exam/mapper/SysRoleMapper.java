package com.monk.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.monk.exam.entity.SysRole;
import org.apache.ibatis.annotations.Select;

/**
 * sys_role 表数据库访问层
 * 后台用户角色表
 *
 * @author monk
 * @since 2022-04-25 15:35:24
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据用户ID查找对应权限
     *
     * @param sysUserId 用户ID
     * @return SysRole 权限实体类
     */
    @Select("select * from sys_role where id in(select role_id from sys_user_role where user_id=#{sysUserId})")
    SysRole querySysRoleBySysUserId(Long sysUserId);
}