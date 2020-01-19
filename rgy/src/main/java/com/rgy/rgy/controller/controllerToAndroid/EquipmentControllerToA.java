package com.rgy.rgy.controller.controllerToAndroid;


import com.rgy.rgy.bean.Equipment;
import com.rgy.rgy.bean.EquipmentType;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    public Result findByCondition(@RequestParam(required = false) String equipmentName,
                                  @RequestParam(required = false) String equipmentTypeID,
                                  @RequestParam(required = false) String voltageLevel,
                                  @RequestParam(required = false) Integer powerPlantID){
        Map<Equipment, EquipmentType> equipment = equipmentService.findByCondition(equipmentName,
                equipmentTypeID,voltageLevel,powerPlantID);
        if(equipment != null){
            return new Result("success","查找成功",equipment);
        }else{
            return new Result("error","查找失败");
        }
    }

    /**
     * 根据电厂ID查找设备
     * 带设备类型查找
     * @param powerPlantID
     * @return
     */
    @GetMapping("/findByPowerPlanID")
    public Result findByPowerPlantId(@RequestParam Integer powerPlantID){
        Map<Equipment, EquipmentType> equipment = equipmentService.findByPowerPlantId(powerPlantID);
        if(equipment != null && !equipment.isEmpty()){
            return new Result("success","返回成功",equipment);
        }else{
            return new Result("error","返回失败");
        }
    }

    /**
     * 设备绑定图片
     */
    @RequestMapping("/picUpload")
    @ResponseBody
    public Result fileUpload(@RequestParam("fileName") MultipartFile file,
                             @RequestParam("equipmentId")Integer equipmentId){
        if(file.isEmpty()){
            new Result("error","保存失败");
        }
        String fileName = file.getOriginalFilename();
        System.out.println(fileName+" "+equipmentId);
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);
        String path = "F:\\热工院项目\\rgy-master\\rgy-master\\src\\main\\resources\\contractfiles\\equipment_pic" ;
        String fileName1=path + "\\" + fileName;
        Equipment equipment=equipmentService.findByEquipmentId(equipmentId);
        equipment.setPicUrl1(fileName1);
        equipmentService.update(equipment);
        File dest = new File(fileName1);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }

        try {
            file.transferTo(dest); //保存文件
            return new Result("success","保存成功");
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new Result("error","保存失败");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new Result("error","保存失败");
        }
    }
}
