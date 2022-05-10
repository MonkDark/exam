package com.monk.exam.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.monk.exam.entity.SysRole;
import com.monk.exam.entity.SysUser;
import com.monk.exam.vo.SysUserVO;
import org.apache.ibatis.annotations.*;

/**
 * sys_user 表数据库访问层
 * 后台用户表
 *
 * @author monk
 * @since 2022-04-24 11:43:01
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据用户名和密码多表查询单条数据
     *
     * @param queryWrapper 查询条件
     * @return SysUserVO 后台用户VO对象,包含用户权限
     */
    @Select("  select avatar,create_by,create_time,edit_by,edit_time,email,id,last_login,locked,phone,sex,username from sys_user ${ew.customSqlSegment}")
    // 关联查询
    @Results({
            @Result(column="id",property="id",id=true),
            // 返回sysRole
            @Result(column = "id", property = "sysRole", javaType = SysRole.class,
                    one = @One(
                            select = "com.monk.exam.mapper.SysRoleMapper.querySysRoleBySysUserId"
                    )
            )
    })
    SysUserVO selectOneMultiTable(@Param(Constants.WRAPPER) Wrapper<SysUser> queryWrapper);

    /**
     * 记录登录时间
     *
     * @param id sysUserID
     */
    @Update("UPDATE sys_user set last_login=NOW() WHERE id=#{id}")
    int login(Long id);

    /**
     * 多表分页查询所有数据
     *
     * @param page         分页条件
     * @param queryWrapper 查询条件
     * @return IPage<SysUserVO>  包含所有用户和其对应权限的IPage对象
     */
    @Select(" select id,username,avatar,sex,phone,email,create_time,edit_time,last_login,locked from sys_user ${ew.customSqlSegment}")
    // 关联查询
    @Results({
            @Result(column = "id", property = "id", id = true),
            // 返回sysRole到SysUserVO.sysRole
            @Result(column = "id", property = "sysRole", javaType = SysRole.class,
                    one = @One(
                            select = "com.monk.exam.mapper.SysRoleMapper.querySysRoleBySysUserId"
                    )
            )
    })
    <P extends IPage<SysUserVO>> P selectPageMultiTable(P page, @Param(Constants.WRAPPER) Wrapper<SysUser> queryWrapper);

}