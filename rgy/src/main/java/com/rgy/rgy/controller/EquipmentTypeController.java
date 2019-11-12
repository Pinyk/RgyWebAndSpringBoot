package com.rgy.rgy.controller;

import com.rgy.rgy.bean.EquipmentType;
import com.rgy.rgy.service.EquipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getAll")
    public List<EquipmentType> getAll(){
        return equipmentTypeService.findAll();
    }
}
