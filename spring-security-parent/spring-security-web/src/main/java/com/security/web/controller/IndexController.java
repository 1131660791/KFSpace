package com.security.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页访问
 */
@Controller
@RequestMapping(value = "${setting.api}")
public class IndexController {

    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }

}