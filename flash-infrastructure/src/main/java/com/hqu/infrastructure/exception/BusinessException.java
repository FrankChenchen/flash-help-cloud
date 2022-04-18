package com.hqu.infrastructure.exception;

/**
 * <p>自定义业务异常类<p/>
 *
 * @author 起凡
 */
public class BusinessException extends Exception {
    int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }
}
