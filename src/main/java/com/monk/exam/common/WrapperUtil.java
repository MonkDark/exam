package com.monk.exam.common;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author monk
 * @description 实体类转QueryWrapper工具
 * @date 2022-04-24 23:36
 */
public class WrapperUtil {
    /**
     * 默认对所有字段进行eq查询
     */
    public static <T> QueryWrapper<T> entity2Wrapper(Object obj) {
        return entity2Wrapper(obj, false);
    }
    /**
     * 对设置了condition = SqlCondition.LIKE的实体类字段进行模糊查询
     */
    public static <T> QueryWrapper<T> entity2Wrapper(Object obj, Boolean isLike) {
        Class<?> aClass = obj.getClass();
        Field[] fields = obj.getClass().getDeclaredFields();
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        //遍历属性
        for (Field field : fields) {
            Method method;
            try {
                String fieldName = field.getName();
                //跳过serialVersionUID
                if (fieldName.equals("serialVersionUID")) {
                    continue;
                }
                //获取属性上的注解
                TableField fieldAnnotation = field.getAnnotation(TableField.class);
                TableId idAnnotation = field.getAnnotation(TableId.class);
                //拿到列名
                String value = fieldAnnotation == null ? idAnnotation.value() : fieldAnnotation.value();
                //拿到自定义WHERE运算规则condition
                String condition = fieldAnnotation == null ? null : fieldAnnotation.condition();
                //get方法
                method = aClass.getDeclaredMethod("get" + captureName(fieldName), null);
                Object returnValue = method.invoke(obj);
                if (returnValue instanceof String) {
                    String str = (String) returnValue;
                    //如果condition设置为LIKE,进行模糊查询
                    if (isLike && SqlCondition.LIKE.equals(condition)) {
                        wrapper.like(StringUtils.isNotBlank(str), value, returnValue);
                        //反之,eq()即可
                    } else {
                        wrapper.eq(StringUtils.isNotBlank(str), value, returnValue);
                    }
                } else {
                    wrapper.eq(returnValue != null, value, returnValue);
                }

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return wrapper;
    }

    /**
     * 将字符串的首字母转大写
     *
     * @param str 需要转换的字符串
     * @return 转换后的字符串
     */
    private static String captureName(String str) {
        // 进行字母的ascii编码前移，效率要高于截取字符串进行转换的操作
        char[] cs = str.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

}
