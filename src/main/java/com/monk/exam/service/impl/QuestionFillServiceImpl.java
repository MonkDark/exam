package com.monk.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monk.exam.mapper.QuestionFillMapper;
import com.monk.exam.entity.QuestionFill;
import com.monk.exam.service.QuestionFillService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 * question_fill 表服务实现类
 * 填空题表
 *
 * @author monk
 * @since 2022-04-26 16:49:26
 */
@Transactional(rollbackFor = Exception.class)
@Service("questionFillService")
public class QuestionFillServiceImpl extends ServiceImpl<QuestionFillMapper, QuestionFill> implements QuestionFillService {

}