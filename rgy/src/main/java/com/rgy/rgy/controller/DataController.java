package com.rgy.rgy.controller;


import com.rgy.rgy.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 实验数据
 * @Author: gaoyk
 * @Date: 2019/11/4 20:30
 */
@RestController
@RequestMapping("/datas")
public class DataController {
    @Autowired
    DataService dataService;
}
