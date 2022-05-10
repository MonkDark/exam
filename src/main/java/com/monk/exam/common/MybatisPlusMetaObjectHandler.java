package com.monk.exam.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @description 自动填充处理类,配置实体类字段自动填充的值
 * @author monk
 * @date 2022-04-25 10:26
 */
@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {

    /**
     * 在执行mybatisPlus的insert()和update()时,自动给某些字段填充值
     *
     * @param metaObject 实体类对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 进行强制填充
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "editTime", LocalDateTime.class, LocalDateTime.now());
    }
    /**
     * 在执行mybatisPlus的update()时,自动给某些字段填充值
     *
     * @param metaObject 实体类对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // 如果有值，则不会更新
        // this.setFieldValByName("editTime", LocalDateTime.now(), metaObject);
        // 即使有值，也更新
        this.strictUpdateFill(metaObject, "editTime", LocalDateTime.class, LocalDateTime.now());
    }
}
