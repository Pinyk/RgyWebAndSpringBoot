package com.rgy.rgy.controller;

import com.rgy.rgy.bean.Material;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: AnZhuJun
 * @Date: 2019/11/17 15:19
 */

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    MaterialService materialService;

    /**
     * 新增
      * @param material
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Material material){
        materialService.update(material);
        return new Result("success","操作成功");
    }

    //修改
    @PostMapping("/update")
    public Result update(Material material){
        material.setMaterialID(material.getMaterialID());
        materialService.update(material);
        return new Result("success","操作成功");
    }

    @GetMapping("/findAll")
    public Result findAll(){
        List<Material> materials = materialService.findAll();
        if(materials!=null){
            return new Result("success","返回成功",materials);
        }else{
            return new Result("error","返回失败");
        }
    }

    @GetMapping("/findbyName")
    public Result find(@RequestParam String name){
        List<Material> material = materialService.findByMaterialName(name);
        if(material!=null){
            return new Result("success","查找成功",material);
        }else{
            return new Result("error","查找失败");
        }
    }

    @DeleteMapping("/delete")
    public Result idel(@RequestParam int id){
        if(materialService.cdel(id)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }

}
