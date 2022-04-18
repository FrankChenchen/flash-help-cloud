package com.hqu.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloAccountController {
    @GetMapping("hello")
    public String hello() {
        return "hello account";
    }
}
