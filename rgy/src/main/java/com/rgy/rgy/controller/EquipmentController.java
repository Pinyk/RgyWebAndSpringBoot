package com.rgy.rgy.controller;


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

/**
 * @Author: gaoyk
 * @Date: 2019/11/1 23:19
 */
@CrossOrigin
@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;

    /**
     * 新增设备信息
     * @param equipment
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Equipment equipment){
        if(equipmentService.add(equipment)){
            return new Result("success","新增成功");
        }else{
            return new Result("error","新增失败");
        }
    }

    /**
     * 修改设备信息
     * @param equipment
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody Equipment equipment){
        if(equipmentService.update(equipment)){
            return new Result("success","修改成功");
        }else{
            return new Result("error","修改失败");
        }
    }

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

    @GetMapping("/findByPowerPlantId")
    public Result findById(@RequestParam Integer powerPlantID){
        List<Equipment> equipment = equipmentService.findById(powerPlantID);
        if(equipment != null && !equipment.isEmpty()){
            return new Result("success","返回成功",equipment);
        }else{
            return new Result("error","返回失败");
        }
    }

    /**
     * 删除设备信息
     * @param equipmentId
     * @return
     */
    @GetMapping("/delete")
    public Result delete(@RequestParam Integer equipmentId){
        if(equipmentService.delete(equipmentId)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }

    @RequestMapping("/picUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("fileName") MultipartFile file,
                             @RequestParam("equipmentId")Integer equipmentId){
        if(file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename();
        System.out.println(fileName+" "+equipmentId);
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);
        String path = "D:\\JAVA\\xxb\\RgyWebAndSpringBoot-master\\rgy\\src\\main\\resources\\equipment_pic" ;
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
            return "true";
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        }
    }


}
