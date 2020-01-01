package com.rgy.rgy.controller.controllerToAndroid;


import com.rgy.rgy.bean.Equipment;
import com.rgy.rgy.bean.EquipmentType;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/equipmentToAndroid")
public class EquipmentControllerToA {

    @Autowired
    EquipmentService equipmentService;

    /**
     * 返回所有设备信息
     * @return
     */
    @GetMapping("/findall")
    public Result findAll(){
        List<Equipment> equipment = equipmentService.findAll();
        if(equipment!=null && !equipment.isEmpty()){
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
                                  @RequestParam String voltageLevel,
                                  @RequestParam Integer powerPlantID){
        Map<Equipment, EquipmentType> equipment = equipmentService.findByCondition(equipmentName,
                equipmentTypeID,voltageLevel,powerPlantID);
        if(equipment != null){
            return new Result("success","查找成功",equipment);
        }else{
            return new Result("error","查找失败");
        }
    }

    /**
     * 设备绑定图片
     */
    @PostMapping("/savePicture")
    public Result savePicture(@RequestBody Equipment equipment){return new Result("","");}
}
