package com.hqu.security.authentication;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.hqu.infrastructure.exception.BusinessException;

import java.io.IOException;

public interface AuthService<T> {
    // 常量代表以后可能会拓展的登录方式
    String USERNAME_PASSWORD = "password";
    String WECHAT = "wechat";

    SaTokenInfo login() throws BusinessException, IOException;
}
