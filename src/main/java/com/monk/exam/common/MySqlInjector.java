package com.monk.exam.common;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author monk
 * @description 自定义SQL注入器,拓展MybatisPlus支持批量插入
 * @date 2022-04-28 18:02
 */
@Component
public class MySqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        // 注意：此SQL注入器继承了DefaultSqlInjector(默认注入器)，调用了DefaultSqlInjector的getMethodList方法，保留了mybatis-plus的自带方法
        List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
        // 注入InsertBatchSomeColumn
        // 在!t.isLogicDelete()表示不要逻辑删除字段，!"update_time".equals(t.getColumn())表示不要字段名为 update_time 的字段
        methodList.add(new InsertBatchSomeColumn(t -> !t.isLogicDelete()));
        methodList.add(new MysqlInsertOrUpdateBath());
        return methodList;
    }
}
