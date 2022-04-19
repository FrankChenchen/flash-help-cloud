package com.hqu.account.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hqu.account.service.impl.UserServiceImpl;
import com.hqu.infrastructure.domain.account.entity.User;
import com.hqu.infrastructure.exception.BusinessException;
import com.hqu.infrastructure.pojo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    @PostMapping("register")
    // 接受用户提交的表单
    // 加上 @Validated 代表要对User进行校验
    public R<String> register(@RequestBody @Validated User user) throws BusinessException {

        userService.register(user);
        // 插入到数据库, 不需要管返回值，插入失败会报错，能执行到这边说明已经插入成功。
        return R.ok("注册成功");
    }

    // path variable写法
    @GetMapping("{username}")
    public R<User> findByUsername(@PathVariable String username) {
        // getOne 传入查询条件
        User one = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
        return R.ok(one);
    }
}

