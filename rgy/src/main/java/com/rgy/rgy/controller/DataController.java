package com.rgy.rgy.controller;


import com.rgy.rgy.bean.Datas;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 实验数据
 * @Author: gaoyk
 * @Date: 2019/11/4 20:30
 */
@CrossOrigin
@RestController
@RequestMapping("/datas")
public class DataController {
    @Autowired
    DataService dataService;

    /**
     * 新增实验数据
     * @param datas
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody List<Datas> datas){
        if(dataService.add(datas)){
            return new Result("success","新增成功");
        }else{
            return new Result("error","新增失败");
        }
    }

    @GetMapping("/findall")
    public Result findall(){
        List<Datas> datas = dataService.findall();
        if(datas != null && !datas.isEmpty()){
            return new Result("success","返回成功",datas);
        }else{
            return new Result("error","返回失败");
        }
    }
}
