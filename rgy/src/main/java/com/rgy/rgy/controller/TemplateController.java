package com.rgy.rgy.controller;

import com.rgy.rgy.bean.Result;
import com.rgy.rgy.bean.Template;
import com.rgy.rgy.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 报告模板
 * @Author: gaoyk
 * @Date: 2019/10/30 21:38
 */

@CrossOrigin
@RestController
@RequestMapping("/template")
public class TemplateController {
    @Autowired
    TemplateService templateService;

    /**
     * 返回所有模板
     * @return
     */
    @GetMapping("/retall")
    public Result retall(){
        List<Template> templates = templateService.retall();
        if(templates == null){
            return new Result("error","未查询到模板");
        }
        return new Result("success","查询成功",templates);
    }

    /**
     * 新增模板
     * @param templateName
     * @param basis
     * @param equipmentTypeId
     * @param editor
     * @return
     */
    @PostMapping("/add")
    public Result tadd(@RequestParam String templateName,@RequestParam String basis,
                       @RequestParam String equipmentTypeId,@RequestParam String editor){
        int templateId = templateService.tadd(templateName,basis,equipmentTypeId,editor);
        return new Result("success","新增成功",templateId);
    }

    /**
     * 查询模板
     * @param templateName
     * @return
     */
    @GetMapping("/name")
    public Result tquery(@RequestParam String templateName){
        Template template = templateService.tquery(templateName);
        if(template!=null){
            return new Result("success","查找成功",template);
        }else{
            return new Result("error","查找失败");
        }
    }

    /**
     * 删除模板
     * @param templateId
     * @return
     */
    @GetMapping("/delete")
    public Result tdel(@RequestParam int templateId){
        if(templateService.tdel(templateId)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }
}
