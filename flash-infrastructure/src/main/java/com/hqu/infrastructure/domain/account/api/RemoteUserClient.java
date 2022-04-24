package com.hqu.infrastructure.domain.account.api;

import com.hqu.infrastructure.domain.account.api.fallback.RemoteUserClientFallback;
import com.hqu.infrastructure.domain.account.entity.User;
import com.hqu.infrastructure.exception.BusinessException;
import com.hqu.infrastructure.pojo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "flash-account", contextId = "user", url = "http://flash-account:7700", fallback = RemoteUserClientFallback.class)
@Primary
public interface RemoteUserClient {
    @GetMapping("/user/find-by-username/{username}")
    R<User> getByUsername(@PathVariable String username) throws BusinessException;
}
