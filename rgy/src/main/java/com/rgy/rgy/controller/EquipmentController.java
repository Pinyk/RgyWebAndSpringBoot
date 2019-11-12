package com.rgy.rgy.controller;


import com.rgy.rgy.bean.Equipment;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: gaoyk
 * @Date: 2019/11/1 23:19
 */

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;

    /**
     * 新增、修改设备
     * 暂时传递对象，电厂字段暂时没有
     * @param equipment
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Equipment equipment){
        equipmentService.add(equipment);
        return new Result("success","操作成功");
    }

    /**
     * 返回所有设备信息
     * @return
     */
    @GetMapping("/findAll")
    public Result findAll(){
        List<Equipment> equipment = equipmentService.findALl();
        if(equipment!=null){
            return new Result("success","返回成功",equipment);
        }else{
            return new Result("error","返回失败");
        }
    }

    /**
     * 条件组合查询
     * @param equipmentName
     * @param equipmentTypeID
     * @param voltageLevel
     * @return
     */
    @GetMapping("/findByCondition")
    public Result findByCondition(@RequestParam String equipmentName,
                                  @RequestParam String equipmentTypeID,
                                  @RequestParam String voltageLevel){
        List<Equipment> equipment = equipmentService.findByCondition(equipmentName,
                equipmentTypeID,voltageLevel);
        if(equipment != null){
            return new Result("success","查找成功",equipment);
        }else{
            return new Result("error","查找失败");
        }
    }
}
