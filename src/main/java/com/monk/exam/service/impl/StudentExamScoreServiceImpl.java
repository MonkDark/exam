package com.monk.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monk.exam.mapper.StudentExamScoreMapper;
import com.monk.exam.entity.StudentExamScore;
import com.monk.exam.service.StudentExamScoreService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 * student_exam_score 表服务实现类
 * 学生考试成绩表
 *
 * @author monk
 * @since 2022-05-09 15:34:19
 */
@Transactional(rollbackFor = Exception.class)
@Service("studentExamScoreService")
public class StudentExamScoreServiceImpl extends ServiceImpl<StudentExamScoreMapper, StudentExamScore> implements StudentExamScoreService {

}