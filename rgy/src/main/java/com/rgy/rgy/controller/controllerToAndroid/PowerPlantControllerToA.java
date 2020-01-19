package com.rgy.rgy.controller.controllerToAndroid;


import com.rgy.rgy.bean.PowerPlant;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.PowerPlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/powerToAndroid")
public class PowerPlantControllerToA {
    @Autowired
    PowerPlantService powerPlantService;

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
}
