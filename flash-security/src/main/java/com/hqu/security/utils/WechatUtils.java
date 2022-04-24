package com.hqu.security.utils;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.hqu.infrastructure.constants.HttpStatus;
import com.hqu.infrastructure.exception.BusinessException;
import com.hqu.security.config.WechatKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WechatUtils {
    @Autowired
    WechatKeys wechatKeys;

    public JSONObject getSession(String code) throws BusinessException {
        // 对应微信小程序官方登录流程图的 3.1
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={0}&secret={1}&js_code={2}&grant_type=authorization_code";
        url = url.replace("{0}", wechatKeys.getAppId()).replace("{1}", wechatKeys.getAppSecret().trim()).replace("{2}", code);
        String res = HttpUtil.get(url);
        // 3.2 解析结果，如果解析出openId则说明用户的授权码有效。这步相当于 “UsernamePassword” 登录方式中的密码校验步骤。
        JSONObject jsonObject = JSONObject.parseObject(res);
        if (jsonObject.get("openid") != null) {
            return jsonObject;
        }
        throw new BusinessException(HttpStatus.BAD_REQUEST, "授权码错误");
    }
}
