package com.hqu.account.service.impl;

import com.hqu.infrastructure.domain.account.entity.UserRole;
import com.hqu.account.dao.UserRoleMapper;
import com.hqu.account.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户关联角色表 服务实现类
 * </p>
 *
 * @author 起凡
 * @since 2022-04-19
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
