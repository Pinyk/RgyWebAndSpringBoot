package com.rgy.rgy.controller.controllerToAndroid;


import com.rgy.rgy.bean.EquipmentType;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.EquipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/equipmentTypeToAndroid")
public class EquipmentTypeControllerToA {
    @Autowired
    EquipmentTypeService equipmentTypeService;

    /**
     * 返回所有类型
     * @return
     */
    @GetMapping("/getall")
    public Result getAll(){
        List<EquipmentType> equipmentTypes = equipmentTypeService.findAll();
        if(equipmentTypes != null && !equipmentTypes.isEmpty()){
            return new Result("success","返回成功",equipmentTypes);
        }else{
            return new Result("error","返回失败");
        }

    }
}
