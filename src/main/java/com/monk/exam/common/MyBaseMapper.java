package com.monk.exam.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author monk
 * @description 根Mapper,自定义通用方法
 * @date 2022-04-28 18:02
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {
    /**
     * 批量插入 仅适用于mysql
     * {@link com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn}
     *
     * @param entityList 实体列表
     * @return 影响行数
     */
    int insertBatchSomeColumn(List<T> entityList);

    /**
     * 自定义批量新增或更新
     * 如果要自动填充，@Param(xx) xx参数名必须是 list/collection/array 3个的其中之一
     */
    int mysqlInsertOrUpdateBath(@Param("list") List<T> list);
}