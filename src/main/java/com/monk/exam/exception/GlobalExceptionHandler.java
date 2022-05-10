package com.monk.exam.exception;

import com.monk.exam.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 参数绑定异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public Result<?> handleBindException(BindException e) {
        log.error("参数绑定校验异常", e);
        return wrapperBindingResult(e.getBindingResult());
    }

    /**
     * 参数校验异常，将校验失败的所有异常组合成一条错误信息
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<?> handleValidException(MethodArgumentNotValidException e) {
        log.error("参数绑定校验异常", e);

        return wrapperBindingResult(e.getBindingResult());
    }

    /**
     * @param e 异常
     * @return 异常结果
     */
    @ResponseBody
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result<?> handlerIllegalArgumentException(IllegalArgumentException e) {
        log.error("Assert异常：----------------{}", e.getMessage());
        return Result.error(e.getMessage());
    }

    /**
     * 处理空指针的异常
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public Result<?> exceptionHandler(NullPointerException e){
        log.error("发生空指针异常！原因是:"+e.getMessage());
        return Result.error(400, "请求的数据格式不符!");
    }

    /**
     * 处理其他异常
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public Result<?> exceptionHandler(Exception e){
        log.error("未知异常！原因是:"+e.getMessage());
        return Result.error(500, "服务器内部错误!");
    }

    /**
     * 包装绑定异常结果
     *
     * @param bindingResult 绑定结果
     * @return 异常结果
     */
    private Result<?> wrapperBindingResult(BindingResult bindingResult) {
        StringBuilder msg = new StringBuilder();

        for (ObjectError error : bindingResult.getAllErrors()) {
            msg.append(", ");
            if (error instanceof FieldError) {
                msg.append(((FieldError) error).getField()).append(": ");
            }
            msg.append(error.getDefaultMessage() == null ? "" : error.getDefaultMessage());

        }

        return Result.error(400, msg.substring(2));
    }
}
