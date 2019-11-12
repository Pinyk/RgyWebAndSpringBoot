package com.rgy.rgy.controller;

import com.rgy.rgy.bean.Params;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.ParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: gaoyk
 * @Date: 2019/11/5 22:13
 */
@RestController
@RequestMapping("/params")
public class ParamsController {
    @Autowired
    ParamsService paramsService;

    /**
     * 新增参数
     * @param params
     * @return
     */
    @PostMapping("/add")
    public Result padd(@RequestBody Params params){
        if(paramsService.padd(params)){
            return new Result("success","添加成功");
        }else{
            return new Result("error","添加失败");
        }
    }


}
