package com.hqu.infrastructure.exception;

import cn.dev33.satoken.exception.NotLoginException;
import com.hqu.infrastructure.constants.HttpStatus;
import com.hqu.infrastructure.pojo.R;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>其他地方抛出的异常会在这里统一拦截,并返回给前端<p/>
 *
 * @author 起凡
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 统一拦截所有的校验失败异常
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public R<String> validateExceptionHandler(MethodArgumentNotValidException e) {
        e.printStackTrace();
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return R.fail(HttpStatus.BAD_REQUEST, message);

    }

    // 未登录异常
    @ExceptionHandler(NotLoginException.class)
    public R<String> notLoginExceptionHandler(NotLoginException e) {
        return R.fail(HttpStatus.UNAUTHORIZED, "请登录");
    }

    // 拦截本系统的业务异常
    @ExceptionHandler({BusinessException.class})
    public R<String> businessExceptionHandler(BusinessException e) {
        e.printStackTrace();
        return R.fail(e.code, e.getMessage());
    }

    // 兜底异常拦截, 有一些异常不属于上面的任何一种
    @ExceptionHandler({Exception.class})
    public R<String> exceptionHandler(Exception e) {
        e.printStackTrace();
        return R.fail("系统内部异常，请稍后重试");
    }
}
