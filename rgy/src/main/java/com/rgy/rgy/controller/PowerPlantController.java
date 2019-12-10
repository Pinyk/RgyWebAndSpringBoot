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
     * @param powerPlantNames
     * @param powerPlantTypes
     * @param generatorCapacitys
     * @param voltageLevels
     * @return
     */
    @GetMapping("/findcondition")
    public Result findByCondition(@RequestParam(required = false) String powerPlantNames,
                                  @RequestParam(required = false) String powerPlantTypes,
                                  @RequestParam(required = false) String generatorCapacitys,
                                  @RequestParam(required = false) String voltageLevels) {
        List<PowerPlant> powerPlants = powerPlantService.findByCondition(powerPlantNames,
                powerPlantTypes, generatorCapacitys, voltageLevels);
        if (powerPlants != null && !powerPlants.isEmpty()) {
            return new Result("success", "返回成功", powerPlants);
        } else {
            return new Result("error", "返回失败");
        }
    }

    /**
     * 返回每个类型电厂列表
     * @return
     */
    @GetMapping("/findByType")
    public Result findByType(){
        List<List<PowerPlant>> powerPlants = powerPlantService.findByType();
        if (powerPlants != null && !powerPlants.isEmpty()) {
            return new Result("success", "返回成功", powerPlants);
        } else {
            return new Result("error", "返回失败");
        }
    }
}
