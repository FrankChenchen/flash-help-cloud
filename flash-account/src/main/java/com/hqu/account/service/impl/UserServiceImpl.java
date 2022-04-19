package com.hqu.account.service.impl;

import com.hqu.infrastructure.domain.account.entity.User;
import com.hqu.account.dao.UserMapper;
import com.hqu.account.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
