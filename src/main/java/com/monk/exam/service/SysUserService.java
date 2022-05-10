package com.monk.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.monk.exam.common.Result;
import com.monk.exam.dto.SysUserDTO;
import com.monk.exam.entity.SysUser;
import com.monk.exam.vo.SysUserVO;

import java.util.List;

/**
 * sys_user 表服务接口
 * 后台用户表
 *
 * @author monk
 * @since 2022-04-24 11:43:01
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * @description 根据用户名和密码多表查询单条数据,记录登录时间
     * @param paramDto DTO 实体对象
     * @return SysUserVO 后台用户VO对象,包含用户权限
     */
    SysUserVO getOneMultiTable(SysUserDTO paramDto);

    /**
     * @description 多表分页查询所有数据
     * @param page 查询设置
     * @param paramDto 查询条件
     * @return IPage<SysUserVO>  包含所有用户和其对应权限的IPage对象
     */
    <E extends IPage<SysUserVO>> E pageMultiTable(E page, SysUserDTO paramDto);

    /**
     * @description 新增数据,多表
     * @param paramDto DTO 实体对象
     * @return Result<?> 封装结果类
     */
    Result<?> saveMultiTable(SysUserDTO paramDto);

    /**
     * @description 根据ID删除数据,多表
     * @param id 主键
     * @return 封装结果类
     */
    Result<?> removeByIdMultiTable(Long id);

    /**
     * @description 根据ID批量删除数据,多表
     * @param idList 主键集合
     * @return 封装结果类
     */
    Result<?> removeBatchByIdsMultiTable(List<Integer> idList);

    /**
     * @description 记录登录时间
     * @param id 主键
     */
    void login(Long id);
}