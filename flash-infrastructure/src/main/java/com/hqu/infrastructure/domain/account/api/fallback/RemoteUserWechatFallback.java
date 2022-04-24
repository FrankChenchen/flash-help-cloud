package com.hqu.infrastructure.domain.account.api.fallback;

import com.hqu.infrastructure.constants.HttpStatus;
import com.hqu.infrastructure.domain.account.api.RemoteUserWechatClient;
import com.hqu.infrastructure.domain.account.entity.UserWechat;
import com.hqu.infrastructure.exception.BusinessException;
import com.hqu.infrastructure.pojo.R;
import org.springframework.stereotype.Component;

@Component
public class RemoteUserWechatFallback implements RemoteUserWechatClient {

    @Override
    public R<UserWechat> getByOpenId(String openId) throws BusinessException {
        throw new BusinessException(HttpStatus.ERROR, "微信用户查询失败");
    }

    @Override
    public R<UserWechat> register(String openId, String serviceName) throws BusinessException {
        throw new BusinessException(HttpStatus.ERROR, "微信用户注册失败");
    }
}
