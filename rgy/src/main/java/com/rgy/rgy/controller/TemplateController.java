package com.rgy.rgy.controller;

import com.rgy.rgy.bean.Items;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.bean.Template;
import com.rgy.rgy.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.TreeMap;

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
    @GetMapping("/findall1")
    public Result findAll2(){
        List templates = templateService.retall();
        if(templates == null || templates.isEmpty()){
            return new Result("error","查询失败");
        } else {
            return new Result("success","查询成功", templates);
        }
    }

    @GetMapping("/findall2")
    public Result findAll (){
        List<Template> all = templateService.findAll();
        if (all != null && !all.isEmpty()) {
            return new Result( "success", "查询成功", all );
        } else {
            return new Result( "error", "查询失败" );
        }
    }

    @GetMapping("/findall")
    public Result retall(){
        List msg = templateService.retall();
        if(msg != null && !msg.isEmpty()){
            return new Result("success","查询成功",msg);
        }else{
            return new Result("error","未查询到模板");
        }
    }

    /**
     * 新增模板
     * @param template
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Template template){
        int templateId = templateService.add(template);
        if (templateId != -1) {
            return new Result("success","新增成功",templateId);
        } else {
            return new Result( "error", "新增失败" );
        }
    }

    /**
     * 查询模板
     * @param templateName
     * @return
     */
    @GetMapping("/findByName")
    public Result findByNameLike(@RequestParam String templateName){
        List<Template> byNameLike = templateService.findByNameLike( templateName );

        if(byNameLike != null && !byNameLike.isEmpty()){
            return new Result("success","查找成功", byNameLike);
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
    public Result del(@RequestParam Integer templateId){
        if(templateService.del(templateId)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Template template) {
        if (templateService.update(template)) {
            return new Result( "success", "修改成功" );
        } else {
            return new Result( "error", "修改失败" );
        }
    }

    @GetMapping("/findByTemplateId")
    public Result findById(@RequestParam Integer templateId){
        List msg = templateService.findBytId(templateId);
        if(msg != null && !msg.isEmpty()){
            return new Result("success","返回成功",msg);
        }else{
            return new Result("error","返回失败");
        }
    }
}
