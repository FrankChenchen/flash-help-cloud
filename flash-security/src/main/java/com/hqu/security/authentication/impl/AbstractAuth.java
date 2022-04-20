package com.hqu.security.authentication.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.hutool.json.JSONUtil;
import com.hqu.infrastructure.exception.BusinessException;
import com.hqu.security.authentication.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <p>因为不同的登录方式接受的表单不一样，为了方便以后拓展，定义一个抽象类将请求 body 根据 type 转成子类需要的表单类型。</p>
 *
 * @author 起凡
 */
@Service
public abstract class AbstractAuth<T> implements AuthService<T> {
    @Autowired
    HttpServletRequest request;

    @Override
    public SaTokenInfo login() throws BusinessException, IOException {
        // 获取body字节流
        ServletInputStream inputStream = request.getInputStream();
        byte[] bytes = inputStream.readAllBytes();
        // 将字节转成字符串
        String body = new String(bytes);
        // 因为字符串是json格式，将字符串转成子类需要的类型
        // support()会返子类需要的类型，比如 UsernamePasswordAuth 调用 support() 会返回 UsernamePasswordForm.class
        T model = JSONUtil.toBean(body, support());
        // model就是子类需要的类型了，传给真正的login逻辑实现
        return login0(model);
    }

    // 子类的实现登录逻辑并返回token
    abstract SaTokenInfo login0(T model) throws BusinessException;

    // 子类需要的表单类型
    abstract Class<T> support();
}
