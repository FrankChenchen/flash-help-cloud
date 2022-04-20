package com.hqu.security.authentication.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.hqu.infrastructure.constants.HttpStatus;
import com.hqu.infrastructure.domain.account.api.RemoteUserClient;
import com.hqu.infrastructure.domain.account.entity.User;
import com.hqu.infrastructure.exception.BusinessException;
import com.hqu.security.dto.UsernamePasswordForm;
import com.hqu.security.authentication.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// service的名称是支持的登录type
// 现然这个实现类支持的方式是UsernamePassword
// 到时候controller那边会根据请求中的type值选择相应的登录实现类
@Service(AuthService.USERNAME_PASSWORD)
@Slf4j
public class UsernamePasswordAuth extends AbstractAuth<UsernamePasswordForm> {
    @Autowired
    RemoteUserClient remoteUserClient;
    @Autowired
    PasswordEncoder passwordEncoder;

    // 父类会根据support返回的类型，将body字符串转成UsernamePasswordForm
    @Override
    public SaTokenInfo login0(UsernamePasswordForm model) throws BusinessException {
        log.info(model.toString());
        // 远程调用查询用户信息
        User data = remoteUserClient.getByUsername(model.getUsername()).getData();
        if (data == null) {
            throw new BusinessException(HttpStatus.NOT_FOUND, "用户不存在");
        }
        // 比对密码是否正确
        if (passwordEncoder.matches(model.getPassword(), data.getPassword())) {
            // 生成token
            StpUtil.login(data.getId());
            // 返回token
            return StpUtil.getTokenInfo();
        }
        throw new BusinessException(HttpStatus.BAD_REQUEST, "密码错误");
    }

    @Override
    Class<UsernamePasswordForm> support() {
        return UsernamePasswordForm.class;
    }

}
