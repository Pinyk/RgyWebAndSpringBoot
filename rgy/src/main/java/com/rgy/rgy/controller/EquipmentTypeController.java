package com.rgy.rgy.controller;

import com.rgy.rgy.bean.Equipment;
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

@CrossOrigin
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
     * 新增设备类型
     * @param equipmentType
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody EquipmentType equipmentType){
        if(equipmentTypeService.eadd(equipmentType)){
            return new Result("success","新增成功");
        }else{
            return new Result("error","新增失败");
        }
    }

    /**
     * 修改设备类型
     * @param equipmentType
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody EquipmentType equipmentType){
        if(equipmentTypeService.update(equipmentType)){
            return new Result("success","更新成功");
        }else{
            return new Result("error","更新失败");
        }
    }

    /**
     * 根据设备类型名查找
     * @param equipmentTypeNames
     * @return
     */
    @GetMapping("/findbyName")
    public Result find(@RequestParam(required = false) String equipmentTypeNames){
        List<EquipmentType> equipmentType = equipmentTypeService.find(equipmentTypeNames);
        if(equipmentType!=null && !equipmentType.isEmpty()){
            return new Result("success","查找成功",equipmentType);
        }else{
            return new Result("error","查找失败");
        }
    }

    /**
     * 删除设备类型
     * @param equipmentTypeID
     * @return
     */
    @GetMapping("/delete")
    public Result delete(@RequestParam Integer equipmentTypeID){
        if(equipmentTypeService.delete(equipmentTypeID)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }

    @GetMapping("/findById")
    public Result findById(@RequestParam Integer equipmentTypeID){
        EquipmentType equipment = equipmentTypeService.findById(equipmentTypeID);
        if(equipment != null){
            return new Result("success","成功",equipment);
        }else{
            return new Result("error","失败");
        }
    }
}
