package com.monk.exam.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monk.exam.common.Result;
import com.monk.exam.dto.SysUserDTO;
import com.monk.exam.entity.SysUser;
import com.monk.exam.service.SysUserService;
import com.monk.exam.vo.SysUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * sys_user 表控制层
 * 后台用户表
 *
 * @author monk
 * @since 2022-04-25 11:13:42
 */
@Api(tags = "后台用户表")
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * @description 根据用户名和密码多表查询单条数据,完成登录验证
     * @param paramDto DTO 实体对象
     * @return SysUserVO 后台用户VO对象,包含用户权限
     */
    @PostMapping("login")
    @ApiOperation("根据用户名密码查询后台用户表,完成登录")
    public Result<?> login(@RequestBody SysUserDTO paramDto){
        // 验证用户信息
        SysUserVO sysUserVO = sysUserService.getOneMultiTable(paramDto);
        // 验证查询结果
        if (sysUserVO == null) {
            return Result.error("用户名或密码错误");
        }
        if (sysUserVO.getLocked() == 1) {
            return Result.error("账户被锁定，请联系管理员");
        }
        // 记录登录时间
        sysUserService.login(sysUserVO.getId());
        return Result.success(sysUserVO);
    }

    /**
     * @description 多表分页查询所有数据
     * @param paramDto DTO 查询实体
     * @return Page<SysUserVO>  包含所有用户和其对应权限的IPage对象
     */
    @PostMapping("selectByCondition")
    @ApiOperation("按字段条件分页查询后台用户表")
    public Result<?> selectSysUserByCondition(@RequestBody SysUserDTO paramDto) {
        return Result.success(sysUserService
                .pageMultiTable(new Page<>(paramDto.getCurrentPage(), paramDto.getPageSize()), paramDto));
    }

    /**
     * @description 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("根据id查询后台用户表")
    public Result<?> selectById(@PathVariable("id") Long id) {
        SysUser sysUser = sysUserService.getById(id);
        //查询结果类型转换
        SysUserVO sysUserVO = new SysUserVO();
        BeanUtils.copyProperties(sysUser,sysUserVO);
        return Result.success(sysUserVO);
    }

    /**
     * @description 新增数据
     * @param paramDto DTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增后台用户表数据")
    public Result<?> addSysUser(@RequestBody SysUserDTO paramDto) {
        //设置时间
        LocalDateTime dateTime = LocalDateTime.now();
        paramDto.setCreateTime(dateTime);
        paramDto.setEditTime(dateTime);
        //默认权限，暂不允许手动设置
        paramDto.setCode("teacher");
        return sysUserService.saveMultiTable(paramDto);
    }
    
    
    /**
     * @description 修改数据
     * @param paramDto DTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("根据Id更新后台用户表")
    public Result<?> updateById(@RequestBody SysUserDTO paramDto) {
        //数据校验
        
        //类型转换
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(paramDto,sysUser);
        return Result.flag(sysUserService.updateById(sysUser));
    }
    
    /**
     * @description 批量修改数据
     * @param paramDtoList DTO 实体对象
     * @return 修改结果
     */
    @PutMapping("updateList")
    @ApiOperation("根据idList批量更新后台用户表")
    public Result<?> updateSysUserList(@RequestBody List<SysUserDTO> paramDtoList) {
        //数据校验
        
        //类型转换
        List<SysUser> sysUserList = Convert.convert(new TypeReference<List<SysUser>>(){}, paramDtoList);
        return Result.flag(sysUserService.updateBatchById(sysUserList));
    }
    
    /**
     * @description 删除单条数据
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("{id}")
    @ApiOperation("根据id删除后台用户表数据")
    public Result<?> deleteById(@PathVariable("id") Long id) {
        return sysUserService.removeByIdMultiTable(id);
    }
    
    /**
     * @description 批量删除数据
     * @param idList 主键集合
     * @return 删除结果
     */
    @DeleteMapping("deleteByIdList")
    @ApiOperation("根据idList批量删除后台用户表数据")
    public Result<?> deleteByIds(@RequestParam("ids") List<Integer> idList) {
        return sysUserService.removeBatchByIdsMultiTable(idList);
    }
}