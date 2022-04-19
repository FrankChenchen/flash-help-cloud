package com.hqu.account.service.impl;

import com.hqu.infrastructure.domain.account.entity.Role;
import com.hqu.account.dao.RoleMapper;
import com.hqu.account.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author 起凡
 * @since 2022-04-19
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
