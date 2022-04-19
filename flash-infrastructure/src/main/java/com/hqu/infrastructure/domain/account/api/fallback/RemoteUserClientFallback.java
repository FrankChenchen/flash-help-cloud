package com.hqu.infrastructure.domain.account.api.fallback;

import com.hqu.infrastructure.constants.HttpStatus;
import com.hqu.infrastructure.domain.account.api.RemoteUserClient;
import com.hqu.infrastructure.domain.account.entity.User;
import com.hqu.infrastructure.exception.BusinessException;
import com.hqu.infrastructure.pojo.R;
import org.springframework.stereotype.Component;

@Component
public class RemoteUserClientFallback implements RemoteUserClient {
    @Override
    public R<User> getByUsername(String username) throws BusinessException {
        throw new BusinessException(HttpStatus.ERROR, "获取用户失败");
    }
}