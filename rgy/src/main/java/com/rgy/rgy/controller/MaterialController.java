package com.rgy.rgy.controller;

import com.rgy.rgy.bean.Material;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: gaoyk
 * @Date: 2019/11/17 15:19
 */

@CrossOrigin
@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    MaterialService materialService;

    /**
     * 新增
     * @param file
     * @param materialName
     * @return
     */
    @PostMapping("/fileUpload")
    public Result fileUpload(@RequestParam("file") MultipartFile file, @RequestParam String materialName){
        if(file.isEmpty()){
            return new Result("error","上传失败");
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);
        String path = "F:\\热工院项目\\rgy-master\\rgy-master\\src\\main\\resources\\materialfiles" ;
        File dest = new File(path + "/" + fileName);
        String root = dest.getAbsolutePath();
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            if(materialService.add(materialName,root)){
                return new Result("success","上传成功");
            }else{
                return new Result("error","上传失败");
            }
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new Result("error","上传失败");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new Result("error","上传失败");
        }
    }

    /**
     * 修改
     * @param material
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody Material material){
        if(materialService.update(material)){
            return new Result("success","操作成功");
        }else{
            return new Result("error","操作失败");
        }
    }

    @GetMapping("/findAll")
    public Result findAll(){
        List<Material> materials = materialService.findAll();
        if(materials!=null && !materials.isEmpty()){
            return new Result("success","返回成功",materials);
        }else{
            return new Result("error","返回失败");
        }
    }

    @GetMapping("/findByName")
    public Result find(@RequestParam String materialName){
        List<Material> material = materialService.findByMaterialName(materialName);
        if(material!=null && !material.isEmpty()){
            return new Result("success","查找成功",material);
        }else{
            return new Result("error","查找失败");
        }
    }

    @GetMapping("/delete")
    public Result idel(@RequestParam Integer materialID){
        if(materialService.cdel(materialID)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }

}
