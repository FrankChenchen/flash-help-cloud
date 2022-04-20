package com.hqu.infrastructure.security;

import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 不要认证 /error 或者 具有AuthIgnore注解的方法
        if (!request.getRequestURI().equals("/error") && !handlerMethod.hasMethodAnnotation(AuthIgnore.class)) {
            // 校验请求中头中的token是否有效，同时将token对应的用户id存储到threadLocal
            StpUtil.checkLogin();
        }
        return true;
    }
}
