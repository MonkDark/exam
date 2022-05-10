package com.monk.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.monk.exam.entity.StudentPaperAnswer;

import java.util.List;

/**
 * student_paper_answer 表服务接口
 * 学生试卷答案表
 *
 * @author monk
 * @since 2022-05-04 14:12:43
 */
public interface StudentPaperAnswerService extends IService<StudentPaperAnswer> {
    /**
     * @param studentPaperAnswerList 实体对象List
     * @return 新增/修改结果
     * @description 批量新增/修改数据
     */
    boolean mysqlInsertOrUpdateBath(List<StudentPaperAnswer> studentPaperAnswerList);
}