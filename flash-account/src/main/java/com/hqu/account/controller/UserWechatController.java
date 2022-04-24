package com.hqu.account.controller;


import com.hqu.account.service.impl.UserServiceImpl;
import com.hqu.account.service.impl.UserWechatServiceImpl;
import com.hqu.infrastructure.domain.account.entity.UserWechat;
import com.hqu.infrastructure.exception.BusinessException;
import com.hqu.infrastructure.pojo.R;
import com.hqu.infrastructure.security.AuthIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 起凡
 * @since 2022-04-24
 */
@RestController
@RequestMapping("/user-wechat")
public class UserWechatController {
    @Autowired
    UserWechatServiceImpl userWechatService;

    @AuthIgnore
    @GetMapping("find-by-openId/{openId}")
    public R<UserWechat> findByOpenId(@PathVariable String openId) {
        return R.ok(userWechatService.findByOpenId(openId));
    }

    @AuthIgnore
    @GetMapping("register")
    public R<UserWechat> register(@RequestParam String openId, @RequestParam String serviceName) throws BusinessException {
        return R.ok(userWechatService.register(openId, serviceName));
    }
}

