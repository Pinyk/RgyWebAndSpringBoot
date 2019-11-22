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

@CrossOrigin
@RestController
@RequestMapping("/power")
public class PowerPlantController {
    @Autowired
    PowerPlantService powerPlantService;

    /**
     * 增加电厂信息
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
     * 更新电厂信息
     * @param powerPlant
     * @return
     */
    @GetMapping("/update")
    public Result pUpdate(@RequestBody PowerPlant powerPlant){
        if(powerPlantService.update(powerPlant)){
            return new Result("success","更新成功");
        }else{
            return new Result("error","更新失败");
        }
    }

    /**
     * 删除电厂
     * @param powerPlantID
     * @return
     */
    @GetMapping("/delete")
    public Result delete(@RequestParam Integer powerPlantID){
        if(powerPlantService.delete(powerPlantID)){
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
        if(powerPlants != null && !powerPlants.isEmpty()){
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
    public Result findByCondition(@RequestParam(required = false) String powerPlantName,
                                  @RequestParam(required = false) String powerPlantType,
                                  @RequestParam(required = false) String generatorCapacity,
                                  @RequestParam(required = false) String voltageLevel) {
        List<PowerPlant> powerPlants = powerPlantService.findByCondition(powerPlantName,
                powerPlantType, generatorCapacity, voltageLevel);
        if (powerPlants != null && !powerPlants.isEmpty()) {
            return new Result("success", "返回成功", powerPlants);
        } else {
            return new Result("error", "返回失败");
        }
    }

    /**
     * 根据类型查找电厂
     * @param powerPlantType
     * @return
     */
    @GetMapping("/findByType")
    public Result findByType(@RequestParam String powerPlantType){
        List<PowerPlant> powerPlants = powerPlantService.findByType(powerPlantType);
        if (powerPlants != null && !powerPlants.isEmpty()) {
            return new Result("success", "返回成功", powerPlants);
        } else {
            return new Result("error", "返回失败");
        }
    }

}
