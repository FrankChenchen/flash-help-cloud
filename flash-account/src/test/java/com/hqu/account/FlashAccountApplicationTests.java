package com.hqu.account;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class FlashAccountApplicationTests {

    @Test
    void contextLoads() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(14);
        long start = System.currentTimeMillis();
        String encode1 = bCryptPasswordEncoder.encode("123456");
        long end = System.currentTimeMillis();
        String encode2 = bCryptPasswordEncoder.encode("123456");
        System.out.printf("加密耗时: %d毫秒%n", end - start);
        System.out.println();
        System.out.println(encode1);
        System.out.println(encode2);

        start = System.currentTimeMillis();
        boolean matches = bCryptPasswordEncoder.matches("123456", encode1);
        System.out.println(matches);
        end = System.currentTimeMillis();
        System.out.printf("校验耗时: %d毫秒%n", end - start);

    }

}
