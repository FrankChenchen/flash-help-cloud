package com.hqu.security.authentication.impl;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.hqu.infrastructure.domain.account.api.RemoteUserWechatClient;
import com.hqu.infrastructure.domain.account.entity.UserWechat;
import com.hqu.infrastructure.exception.BusinessException;
import com.hqu.security.authentication.AuthService;
import com.hqu.security.dto.WechatForm;
import com.hqu.security.utils.WechatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(AuthService.WECHAT)
public class WechatAuth extends AbstractAuth<WechatForm> {
    @Autowired
    WechatUtils wechatUtils;
    @Autowired
    RemoteUserWechatClient remoteUserWechatClient;

    @Override
    SaTokenInfo login0(WechatForm model) throws BusinessException {
        // 通过授权码获取openId
        JSONObject session = wechatUtils.getSession(model.getCode());
        // openId 微信用户在你的这个小程序对应的openId是唯一的
        String openId = (String) session.get("openid");
        // 从数据库中查找是否存在该微信用户
        UserWechat data = remoteUserWechatClient.getByOpenId(openId).getData();
        if (data == null) {
            // 不存在则注册微信用户
            data = remoteUserWechatClient.register(openId, model.getServiceName()).getData();
        }
        // 登录
        StpUtil.login(data.getUserId());
        // 每个登录过的用户在redis中都存在session
        SaSession saSession = StpUtil.getSession();
        // 通过授权码获取到的wechatSession(包含session_key和openid)
        // 保存到用户对应的session中
        saSession.set("wechat_session", session);
        return StpUtil.getTokenInfo();
    }

    @Override
    Class<WechatForm> support() {
        return WechatForm.class;
    }
}
