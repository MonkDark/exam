package com.monk.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.monk.exam.common.Result;
import com.monk.exam.dto.ExamDTO;
import com.monk.exam.entity.Exam;
import com.monk.exam.vo.ExamVO;

/**
 * exam 表服务接口
 * 考试表
 *
 * @author monk
 * @since 2022-04-28 15:01:55
 */
public interface ExamService extends IService<Exam> {
    /**
     * @param paramDto DTO 实体对象
     * @return Result<?> 封装结果类
     * @description 新增数据, 多表
     */
    Result<?> saveMultiTable(ExamDTO paramDto);
    /**
     * @description 通过主键查询单条数据
     * @param id 主键
     * @return ExamVO
     */
    ExamVO getByIdMultiTable(Long id);
}