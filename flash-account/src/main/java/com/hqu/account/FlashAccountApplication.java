package com.hqu.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 从com.hqu包开始扫描，这样才能扫描到基础设施模块内的bean
@SpringBootApplication(scanBasePackages = "com.hqu")
public class FlashAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlashAccountApplication.class, args);
    }

}
