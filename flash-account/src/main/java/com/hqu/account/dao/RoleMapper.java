package com.hqu.account.dao;

import com.hqu.infrastructure.domain.account.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author 起凡
 * @since 2022-04-19
 */
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> listUserRoles(Long userId);
}
