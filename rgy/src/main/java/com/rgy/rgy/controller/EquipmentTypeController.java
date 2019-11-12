package com.rgy.rgy.controller;

import com.rgy.rgy.bean.EquipmentType;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.EquipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: gaoyk
 * @Date: 2019/10/27 11:15
 */

@RestController
@RequestMapping("/equipmentType")
public class EquipmentTypeController {
    @Autowired
    EquipmentTypeService equipmentTypeService;

    /**
     * 返回所有类型
     * @return
     */
    @GetMapping("/getAll")
    public Result getAll(){
        List<EquipmentType> equipmentTypes = equipmentTypeService.findAll();
        return new Result("success","返回成功",equipmentTypes);
    }

    /**
     * 新增、修改类型
     * @param equipmentTypeName
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestParam String equipmentTypeName){
        equipmentTypeService.eadd(equipmentTypeName);
        return new Result("success","新增成功");
    }

    @GetMapping("/findbyName")
    public Result find(@RequestParam String equipmentTypeName){
        EquipmentType equipmentType = equipmentTypeService.find(equipmentTypeName);
        if(equipmentType!=null){
            return new Result("success","查找成功",equipmentType);
        }else{
            return new Result("error","查找失败");
        }
    }
}
