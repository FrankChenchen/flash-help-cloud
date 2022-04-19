package com.hqu.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.hqu")
@EnableFeignClients("com.hqu.infrastructure.domain")
public class FlashSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlashSecurityApplication.class, args);
    }

}
