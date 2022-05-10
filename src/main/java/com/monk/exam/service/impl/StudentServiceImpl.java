package com.monk.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.monk.exam.mapper.StudentMapper;
import com.monk.exam.entity.Student;
import com.monk.exam.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

/**
 * student 表服务实现类
 * 学生表
 *
 * @author monk
 * @since 2022-04-25 16:28:34
 */
@Transactional(rollbackFor = Exception.class)
@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    /**
     * @description 记录登录时间
     * @param id 主键
     */
    @Override
    public void login(Long id) {
        try {
            if (!SqlHelper.retBool(studentMapper.login(id))) {
                throw new Exception("记录登录时间失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}