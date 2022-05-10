package com.monk.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.monk.exam.entity.Student;

/**
 * student 表服务接口
 * 学生表
 *
 * @author monk
 * @since 2022-04-25 16:28:34
 */
public interface StudentService extends IService<Student> {
    /**
     * @description 记录登录时间
     * @param id 主键
     */
    void login(Long id);
}