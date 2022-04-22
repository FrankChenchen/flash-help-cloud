package com.hqu.account.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import com.hqu.account.service.impl.RoleServiceImpl;
import com.hqu.infrastructure.domain.account.entity.Role;
import com.hqu.infrastructure.pojo.R;
import com.hqu.infrastructure.security.AuthIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author 起凡
 * @since 2022-04-19
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleServiceImpl roleService;

    @SaCheckRole("管理员")
    @PostMapping("save")
    // 表单校验
    public R<Boolean> save(@RequestBody @Validated Role role) {
        // 如果传过来的role有带id，那么就会更新这个id对应的role
        // 否则就是插入role记录
        roleService.saveOrUpdate(role);
        return R.ok(true);
    }

    @AuthIgnore
    @GetMapping("{id}")
    public R<List<Role>> listUserRoles(@PathVariable Long id) {
        return R.ok(roleService.getBaseMapper().listUserRoles(id));
    }
}

