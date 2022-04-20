package com.hqu.security.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.hqu.infrastructure.exception.BusinessException;
import com.hqu.infrastructure.pojo.R;

import com.hqu.infrastructure.security.AuthIgnore;
import com.hqu.security.authentication.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
@Slf4j
public class AuthController {
    // 获取所有的authService实现类bean
    // 键是service名称，值是service bean
    // 比如 通过 password就可以获取到 UsernamePasswordAuth
    // 因为 UsernamePasswordAuth的名称是 password
    @Autowired
    Map<String, AuthService<?>> authServiceMap;

    @AuthIgnore
    @PostMapping("/auth")
    public R<SaTokenInfo> request(HttpServletRequest request) throws BusinessException, IOException {
        // 根据请求中的type参数
        String type = request.getParameter("type");
        // 获取到对应的登录实现类
        AuthService<?> authService = authServiceMap.get(type);
        // 登录
        SaTokenInfo tokenInfo = authService.login();
        // 返回token
        return R.ok(tokenInfo);
    }
}
