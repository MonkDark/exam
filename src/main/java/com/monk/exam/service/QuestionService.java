package com.monk.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monk.exam.dto.QuestionDTO;
import com.monk.exam.vo.QuestionVO;

/**
 * question 题库服务接口
 * 题库(选择表、判断表、填空题表)
 *
 * @author monk
 * @since 2022-04-26 16:49:25
 */
public interface QuestionService {

    /**
     * @description 多表分页查询所有数据
     *
     * @param page 查询设置
     * @param paramDto 查询条件
     * @return IPage<QuestionVO>  所有数据
     */
    <E extends IPage<QuestionVO>> E pageMultiTable(E page, QuestionDTO paramDto);
}