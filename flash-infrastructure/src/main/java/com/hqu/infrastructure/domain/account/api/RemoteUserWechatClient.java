package com.hqu.infrastructure.domain.account.api;

import com.hqu.infrastructure.domain.account.api.fallback.RemoteUserWechatFallback;
import com.hqu.infrastructure.domain.account.entity.UserWechat;
import com.hqu.infrastructure.exception.BusinessException;
import com.hqu.infrastructure.pojo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "flash-account", contextId = "wechat", url = "http://flash-account:7700", fallback = RemoteUserWechatFallback.class)
@Primary
public interface RemoteUserWechatClient {
    @GetMapping("/user-wechat/find-by-openId/{openId}")
    R<UserWechat> getByOpenId(@PathVariable String openId) throws BusinessException;

    @GetMapping("/user-wechat/register")
    R<UserWechat> register(@RequestParam String openId, @RequestParam String serviceName) throws BusinessException;

}
