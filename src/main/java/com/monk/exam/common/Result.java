package com.monk.exam.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @description 对外统一的出口进行封装
 * @author monk
 * @date 2022-04-22 11:55
 */
@Setter
@Getter
@AllArgsConstructor
public class Result<T> {
    /* 状态码 */
    private Integer code;
    /* 提示消息 */
    private String msg;
    /* 具体返回的数据 */
    private T data;

    /**
     * @return Result对象
     */
    public static <T> Result<T> success() {
        return success(Const.SUCCESS,"操作成功",null);
    }

    /**
     * @param flag 操作结果
     * @return Result对象
     */
    public static <T> Result<T> flag(Boolean flag) {
        return flag ? success() : error();
    }

    /**
     * @param msg 成功消息
     * @return Result对象
     */
    public static <T> Result<T> success(String msg) {
        return success(Const.SUCCESS, msg,null);
    }

    /**
     * @param data 返回的数据
     * @return Result对象
     */
    public static <T> Result<T> success(T data) {
        return success(Const.SUCCESS, "操作成功", data);
    }

    /**
     * @param code 成功状态码
     * @param msg 成功消息
     * @param data 返回的数据
     * @return Result对象
     */
    public static <T> Result<T> success(Integer code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    /**
     * @return Result对象
     */
    public static <T> Result<T> error() {
        return error(Const.ERROR, "操作失败", null);
    }

    /**
     * @param msg 失败消息
     * @return Result对象
     */
    public static <T> Result<T> error(String msg) {
        return error(Const.ERROR, msg, null);
    }

    /**
     * @param code 失败状态码
     * @param msg 失败消息
     * @return Result对象
     */
    public static <T> Result<T> error(Integer code, String msg) {
        return error(code, msg, null);
    }

    /**
     * @param code 失败状态码
     * @param msg 失败消息
     * @param data 返回的数据
     * @return Result对象
     */
    public static <T> Result<T> error(Integer code, String msg,T data) {
        return new Result<>(code, msg, data);
    }
}
