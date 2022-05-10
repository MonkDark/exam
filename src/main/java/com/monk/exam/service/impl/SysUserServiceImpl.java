package com.monk.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.monk.exam.common.Result;
import com.monk.exam.common.WrapperUtil;
import com.monk.exam.dto.SysUserDTO;
import com.monk.exam.entity.SysRole;
import com.monk.exam.entity.SysUser;
import com.monk.exam.entity.SysUserRole;
import com.monk.exam.mapper.SysRoleMapper;
import com.monk.exam.mapper.SysUserMapper;
import com.monk.exam.mapper.SysUserRoleMapper;
import com.monk.exam.service.SysUserService;
import com.monk.exam.vo.SysUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import javax.annotation.Resource;
import java.util.List;

/**
 * sys_user 表服务实现T
 * 后台用户表
 *
 * @author monk
 * @since 2022-04-24 11:43:01
 */
@Transactional(rollbackFor = Exception.class)
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * @description 根据用户名和密码多表查询单条数据,记录登录时间
     *
     * @param paramDto DTO 实体对象
     * @return SysUserVO 后台用户VO对象,包含用户权限
     */
    @Override
    public SysUserVO getOneMultiTable(SysUserDTO paramDto) {
        //查询条件复制
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(paramDto, sysUser);
        QueryWrapper<SysUser> queryWrapper = WrapperUtil.entity2Wrapper(sysUser);
        return sysUserMapper.selectOneMultiTable(queryWrapper);
    }

    /**
     * @description 多表分页查询所有数据
     *
     * @param page 查询设置
     * @param paramDto 查询条件
     * @return IPage<SysUserVO>  包含所有用户和其对应权限的IPage对象
     */
    @Override
    public <E extends IPage<SysUserVO>> E pageMultiTable(E page, SysUserDTO paramDto) {
        //查询条件复制
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(paramDto, sysUser);
        // 使用工具类拼接查询条件并开启字段模糊查询
        // 字段需设置@TableField(ondition = SqlCondition.LIKE)
        QueryWrapper<SysUser> queryWrapper = WrapperUtil.entity2Wrapper(sysUser,true);
        return sysUserMapper.selectPageMultiTable(page, queryWrapper);
    }

    /**
     * @description 新增数据,多表
     * @param paramDto DTO 实体对象
     * @return Result<?> 封装结果类
     */
    public Result<?> saveMultiTable(SysUserDTO paramDto) {
        try {
            // 查询用户名是否重复
            if (this.getOne(new LambdaQueryWrapper<SysUser>()
                    .eq(SysUser::getUsername,paramDto.getUsername())) != null){
                return Result.error("此用户名已被占用,请重新输入");
            }
            // 添加SysUser数据
            SysUser sysUser = new SysUser();
            BeanUtils.copyProperties(paramDto,sysUser);
            if (!this.save(sysUser)){
                throw new Exception("添加SysUser数据失败！");
            }
            // 查询SysRole
            SysRole sysRole=new SysRole();
            sysRole.setCode(paramDto.getCode());
            sysRole = sysRoleMapper.selectOne(new QueryWrapper<>(sysRole));
            if (sysRole == null) {
                throw new Exception("查询SysRole数据失败！");
            }
            // 添加SysUserRole数据
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(sysUser.getId());
            sysUserRole.setRoleId(sysRole.getId());
            if (!SqlHelper.retBool(sysUserRoleMapper.insert(sysUserRole))) {
                throw new Exception("添加SysUserRole数据失败！");
            }
            // 封装返回结果
            return Result.success("添加后台用户数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            // @Transactional和try catch捕获异常会让注解失效
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error("添加后台用户数据失败！");
        }
    }

    /**
     * @description 根据ID删除数据,多表
     * @param id 主键
     * @return 封装结果类
     */
    @Override
    public Result<?> removeByIdMultiTable(Long id) {
        try {
            // 判断是否为根用户admin
            if(id == 0){
                return Result.error("根用户无法被删除");
            }
            // 删除SysUserRole数据
            if (!SqlHelper.retBool(sysUserRoleMapper.delete(new LambdaQueryWrapper<SysUserRole>()
                    .eq(SysUserRole::getUserId, id)))) {
                throw new Exception("删除SysUserRole数据失败！");
            }
            // 删除SysUser数据
            if (!this.removeById(id)){
                throw new Exception("删除SysUser数据失败！");
            }
            // 封装返回结果
            return Result.success("删除后台用户数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            // @Transactional和try catch捕获异常会让注解失效
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error("删除后台用户数据失败！");
        }
    }

    @Override
    public Result<?> removeBatchByIdsMultiTable(List<Integer> idList) {
        try {
            // 移除可能被选中的根用户admin
            idList.remove(Integer.valueOf(0));
            // 批量删除SysUserRole数据
            if (!SqlHelper.retBool(sysUserRoleMapper.delete(new LambdaQueryWrapper<SysUserRole>()
                    .in(SysUserRole::getUserId,idList)))) {
                throw new Exception("批量删除SysUserRole数据失败！");
            }
            // 批量删除SysUser数据
            if (!this.removeBatchByIds(idList)){
                throw new Exception("批量删除SysUser数据失败！");
            }
            // 封装返回结果
            return Result.success("批量删除后台用户数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            // @Transactional和try catch捕获异常会让注解失效
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error("批量删除后台用户数据失败！");
        }
    }

    /**
     * @description 记录登录时间
     * @param id 主键
     */
    @Override
    public void login(Long id) {
        try {
            if (!SqlHelper.retBool(sysUserMapper.login(id))) {
                throw new Exception("记录登录时间失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}