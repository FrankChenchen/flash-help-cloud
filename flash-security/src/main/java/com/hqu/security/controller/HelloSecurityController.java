package com.hqu.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSecurityController {
    @GetMapping("hello")
    public String hello() {
        return "hello security";
    }
}
