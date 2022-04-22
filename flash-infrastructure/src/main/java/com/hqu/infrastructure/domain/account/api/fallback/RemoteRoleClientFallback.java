package com.hqu.infrastructure.domain.account.api.fallback;

import com.hqu.infrastructure.constants.HttpStatus;
import com.hqu.infrastructure.domain.account.api.RemoteRoleClient;
import com.hqu.infrastructure.domain.account.entity.Role;
import com.hqu.infrastructure.exception.BusinessException;
import com.hqu.infrastructure.pojo.R;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RemoteRoleClientFallback implements RemoteRoleClient {
    @Override
    public R<List<Role>> listRolesByUserId(Long id) throws BusinessException {
        throw new BusinessException(HttpStatus.ERROR, "角色查询失败");
    }
}
