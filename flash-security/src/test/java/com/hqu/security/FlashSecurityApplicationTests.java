package com.hqu.security;

import com.hqu.infrastructure.domain.account.api.RemoteUserClient;
import com.hqu.infrastructure.domain.account.entity.User;
import com.hqu.infrastructure.exception.BusinessException;
import com.hqu.infrastructure.pojo.R;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FlashSecurityApplicationTests {
    @Autowired
    RemoteUserClient remoteUserClient;

    @Test
    void contextLoads() throws BusinessException {
        User user = remoteUserClient.getByUsername("起凡1").getData();
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }

}
