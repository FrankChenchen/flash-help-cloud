package com.hqu.account.service;

import com.hqu.infrastructure.domain.account.entity.UserWechat;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hqu.infrastructure.exception.BusinessException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 起凡
 * @since 2022-04-24
 */
public interface IUserWechatService extends IService<UserWechat> {
    UserWechat findByOpenId(String openId);
    UserWechat register(String openId, String serviceName) throws BusinessException;
}
