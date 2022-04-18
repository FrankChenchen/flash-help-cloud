package com.hqu.security.controller;

import com.hqu.infrastructure.constants.HttpStatus;
import com.hqu.infrastructure.exception.BusinessException;
import com.hqu.infrastructure.pojo.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSecurityController {
    @GetMapping("hello")
    public R<String> hello() {
        // 使用同一返回格式
        return R.ok("hello security");
    }

    @GetMapping("exception")
    public R<String> exception() throws BusinessException {
        // 在这里抛出异常，基础设施模块里的GlobalExceptionHandler会捕获到BusinessException，
        throw new BusinessException(HttpStatus.ERROR, "security 测试异常");
    }
}
