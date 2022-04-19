package com.hqu.account.service;

import com.hqu.infrastructure.domain.account.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hqu.infrastructure.exception.BusinessException;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 起凡
 * @since 2022-04-19
 */
public interface IUserService extends IService<User> {
    boolean register(User user) throws BusinessException;
}
