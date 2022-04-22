package com.hqu.infrastructure.domain.account.api;

import com.hqu.infrastructure.domain.account.api.fallback.RemoteRoleClientFallback;
import com.hqu.infrastructure.domain.account.entity.Role;
import com.hqu.infrastructure.exception.BusinessException;
import com.hqu.infrastructure.pojo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "flash-account", contextId = "role", url = "http://flash-account:7700", fallback = RemoteRoleClientFallback.class)
@Primary
public interface RemoteRoleClient {
    @GetMapping("/role/{id}")
    R<List<Role>> listRolesByUserId(@PathVariable Long id) throws BusinessException;
}
