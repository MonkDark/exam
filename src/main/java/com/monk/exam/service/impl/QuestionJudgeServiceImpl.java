package com.monk.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monk.exam.mapper.QuestionJudgeMapper;
import com.monk.exam.entity.QuestionJudge;
import com.monk.exam.service.QuestionJudgeService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 * question_judge 表服务实现类
 * 判断题表
 *
 * @author monk
 * @since 2022-04-26 16:48:35
 */
@Transactional(rollbackFor = Exception.class)
@Service("questionJudgeService")
public class QuestionJudgeServiceImpl extends ServiceImpl<QuestionJudgeMapper, QuestionJudge> implements QuestionJudgeService {

}