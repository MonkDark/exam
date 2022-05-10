package com.monk.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monk.exam.mapper.QuestionChoiceMapper;
import com.monk.exam.entity.QuestionChoice;
import com.monk.exam.service.QuestionChoiceService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 * question_choice 表服务实现类
 * 选择题表
 *
 * @author monk
 * @since 2022-04-26 16:49:26
 */
@Transactional(rollbackFor = Exception.class)
@Service("questionChoiceService")
public class QuestionChoiceServiceImpl extends ServiceImpl<QuestionChoiceMapper, QuestionChoice> implements QuestionChoiceService {

}