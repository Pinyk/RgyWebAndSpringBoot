package com.rgy.rgy.controller;


import com.rgy.rgy.bean.PowerPlant;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.PowerPlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: gaoyk
 * @Date: 11/12  00:19
 */

@RestController
@RequestMapping("/power")
public class PowerPlantController {
    @Autowired
    PowerPlantService powerPlantService;

    /**
     * 增加、修改电厂信息
     * @param powerPlant
     * @return
     */
    @PostMapping("/add")
    public Result padd(@RequestBody PowerPlant powerPlant){
        if(powerPlantService.add(powerPlant)){
            return new Result("success","添加成功");
        }else{
            return new Result("error","添加失败");
        }
    }

    /**
     *删除电厂信息
     * @param powerPlantName
     * @return
     */
    @GetMapping("/delete")
    public Result delete(@RequestParam String powerPlantName){
        if(powerPlantService.delete(powerPlantName)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }

    /**
     * 返回所有电厂信息
     * @return
     */
    @GetMapping("/findall")
    public Result findAll(){
        List<PowerPlant> powerPlants = powerPlantService.findAll();
        if(powerPlants != null){
            return new Result("success","返回成功",powerPlants);
        }else{
            return new Result("error","返回失败");
        }
    }

    /**
     * 条件组合查询
     * @param powerPlantName
     * @param powerPlantType
     * @param generatorCapacity
     * @param voltageLevel
     * @return
     */
    @GetMapping("/findcondition")
    public Result findByCondition(@RequestParam String powerPlantName,
                                  @RequestParam String powerPlantType,
                                  @RequestParam String generatorCapacity,
                                  @RequestParam String voltageLevel){
        List<PowerPlant> powerPlants = powerPlantService.findByCondition(powerPlantName,
                powerPlantType,generatorCapacity,voltageLevel);
        if(powerPlants != null){
            return new Result("success","返回成功",powerPlants);
        }else{
            return new Result("error","返回失败");
        }
    }
}
