package com.hqu.account.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hqu.infrastructure.constants.HttpStatus;
import com.hqu.infrastructure.domain.account.entity.User;
import com.hqu.infrastructure.domain.account.entity.UserWechat;
import com.hqu.account.dao.UserWechatMapper;
import com.hqu.account.service.IUserWechatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hqu.infrastructure.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 起凡
 * @since 2022-04-24
 */
@Service
public class UserWechatServiceImpl extends ServiceImpl<UserWechatMapper, UserWechat> implements IUserWechatService {
    @Autowired
    UserServiceImpl userService;

    @Override
    public UserWechat findByOpenId(String openId) {
        // 根据openId查询微信用户
        return getOne(Wrappers.<UserWechat>lambdaQuery().eq(UserWechat::getOpenId, openId));
    }

    @Override
    public UserWechat register(String openId, String serviceName) throws BusinessException {

        UserWechat userWechat = findByOpenId(openId);
        if (userWechat != null) {
            throw new BusinessException(HttpStatus.CONFLICT, "微信用户已存在");
        }
        User user = new User();
        // 来自微信的用户默认密码为空，空密码不可登录
        user.setUsername(RandomUtil.randomString(10)).setServiceName(serviceName);
        userService.save(user);
        userWechat = new UserWechat();
        // user插入到数据库后会返回id，所以这边能getId。
        userWechat.setUserId(user.getId());
        userWechat.setOpenId(openId);
        // 注册微信用户
        save(userWechat);
        return userWechat;
    }
}
