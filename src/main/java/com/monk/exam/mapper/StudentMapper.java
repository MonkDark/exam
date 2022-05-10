package com.monk.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.monk.exam.entity.Student;
import org.apache.ibatis.annotations.Update;

/**
 * student 表数据库访问层
 * 学生表
 *
 * @author monk
 * @since 2022-04-25 16:28:34
 */
public interface StudentMapper extends BaseMapper<Student> {
    /**
     * 记录登录时间
     *
     * @param id sysUserID
     */
    @Update("UPDATE student set last_login=NOW() WHERE id=#{id}")
    int login(Long id);
}