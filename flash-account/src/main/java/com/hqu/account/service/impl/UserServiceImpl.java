package com.hqu.account.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hqu.infrastructure.constants.HttpStatus;
import com.hqu.infrastructure.domain.account.entity.User;
import com.hqu.account.dao.UserMapper;
import com.hqu.account.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hqu.infrastructure.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 起凡
 * @since 2022-04-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean register(User user) throws BusinessException {
        User databaseUser = getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
        if (databaseUser != null) {
            throw new BusinessException(HttpStatus.CONFLICT, "用户已经存在，请更换用户名");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        save(user);
        return true;
    }
}
