package com.rgy.rgy.controller;

import com.rgy.rgy.bean.*;
import com.rgy.rgy.pojo.Ti;
import com.rgy.rgy.pojo.Tip;
import com.rgy.rgy.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 报告模板
 *
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
    @GetMapping("/findall")
    public Result retall(){
        List msg = templateService.retall();
        if(msg != null && !msg.isEmpty()){
            return new Result("success","查询成功",msg);
        }else{
            return new Result("error","未查询到模板");
        }
    }

    @GetMapping("findall1")
    public Result findall(){
        List<Template> msg = templateService.findall();
        if(msg != null && !msg.isEmpty()){
            return new Result("success","查询成功",msg);
        }else{
            return new Result("error","未查询到模板");
        }
    }

    /**
     * 新增报告模板
     * @param template
     * @return
     */
    @PostMapping("/add")
    public Result tadd(@RequestBody Template template){
        Integer templateId = templateService.tadd(template);
        if(templateId != null){
            return new Result("success","新增成功",templateId);
        }else{
            return new Result("error","新增失败");
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Template template){
        if(templateService.update(template)){
            return new Result("success","修改成功");
        }else{
            return new Result("error","修改失败");
        }
    }


    /**
     * 查询模板
     * @param templateName
     * @return
     */
    @GetMapping("/findByName")
    public Result tquery(@RequestParam String templateName){
        List<Template> template = templateService.tquery(templateName);
        if(template!=null && !template.isEmpty()){
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
    public Result tdel(@RequestParam Integer templateId){
        if(templateService.tdel(templateId)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }

    /**
     * 根据模板ID找检测项和参数
     * @param templateId
     * @return
     */
    @GetMapping("/findByTemplateId")
    public Result findById(@RequestParam Integer templateId){
//        LinkedHashMap<Items, List<Params>> msg = templateService.findBytId(templateId);
        List msg = templateService.findBytId(templateId);
        if(msg != null && !msg.isEmpty()){
            return new Result("success","返回成功",msg);
        }else{
            return new Result("error","返回失败");
        }
    }
}
