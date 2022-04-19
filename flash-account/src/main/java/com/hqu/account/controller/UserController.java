package com.hqu.account.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hqu.account.service.impl.UserServiceImpl;
import com.hqu.infrastructure.domain.account.entity.User;
import com.hqu.infrastructure.pojo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 起凡
 * @since 2022-04-19
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("test")
    public R<String> test() {
        User user = new User();
        // 需要在User上加 @Accessors(chain = true) 才能支持下面这种写法
        user.setUsername("测试用户")
                .setPhoneNumber("12345678910")
                .setGender("男")
                .setPassword("123456");
        userService.save(user);
        // 插入到数据库, 不需要管返回值，插入失败会报错，能执行到这边说明已经插入成功。
        return R.ok("测试添加用户成功");
    }

    // path variable写法
    @GetMapping("{username}")
    public R<User> findByUsername(@PathVariable String username) {
        // getOne 传入查询调节
        User one = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
        return R.ok(one);
    }
}

