package com.hqu.infrastructure.security;

import cn.dev33.satoken.stp.StpInterface;
import com.hqu.infrastructure.domain.account.api.RemoteRoleClient;
import com.hqu.infrastructure.domain.account.entity.Role;
import com.hqu.infrastructure.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RolePermissionList implements StpInterface {
    @Autowired
    RemoteRoleClient remoteRoleClient;


    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        try {
            List<Role> roles = remoteRoleClient.listRolesByUserId(Long.valueOf((String) loginId)).getData();
            return roles.stream().map(Role::getName).collect(Collectors.toList());
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
