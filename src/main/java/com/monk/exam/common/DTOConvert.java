package com.monk.exam.common;

/**
 * @author monk
 * @description DTO转换接口
 * @date 2022-05-09 15:07
 */
public interface DTOConvert<S,T> {
    T convert(S s);
}

