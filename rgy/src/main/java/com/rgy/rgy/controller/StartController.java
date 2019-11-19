package com.rgy.rgy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: gaoyk
 * @Date: 2019/11/19 19:17
 */
@Controller

public class StartController {

    @RequestMapping("/")
    public String star(){
        return "index";
    }
}
