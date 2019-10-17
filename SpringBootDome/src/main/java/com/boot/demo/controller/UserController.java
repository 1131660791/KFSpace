package com.boot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userController")
public class UserController {


    // 获取动态参数
    @Value("${par.test_url}")
    private String testUrl;

    @RequestMapping("test")
    public String test(){

        return testUrl;
    }

}