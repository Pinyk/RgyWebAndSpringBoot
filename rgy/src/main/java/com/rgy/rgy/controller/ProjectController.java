package com.rgy.rgy.controller;


import com.rgy.rgy.bean.Project;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: gaoyk
 * @Date: 2019/10/30 21:00
 */
@CrossOrigin
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    /**
     * 增加项目报价表
     * @param project
     * @return
     */
    @PostMapping("/add")
    public Result proAdd(@RequestBody Project project){
        if(projectService.add(project)){
            return new Result("success","添加成功");
        }else{
            return new Result("error","添加失败");
        }
    }

    /**
     * 更新项目报价信息
     * @param project
     * @return
     */
    @PostMapping("/update")
    public Result proUpdate(@RequestBody Project project){
        if(projectService.update(project)){
            return new Result("success","修改成功");
        }else{
            return new Result("error","修改失败");
        }
    }

    /**
     * 删除项目报价表
     * @param projectId
     * @return
     */
    @GetMapping("/delete")
    public Result proDelete(@RequestParam Integer projectId){
        if(projectService.delete(projectId)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }

    /**
     * 返回所有项目报价表
     * @return
     */
    @GetMapping("/findall")
    public Result findAll(){
        List<Project> projects = projectService.findAll();
        if(projects != null && !projects.isEmpty()){
            return new Result("success","返回成功",projects);
        }else{
            return new Result("error","返回失败");
        }
    }

    /**
     * 按条件查询项目报价表
     * @param projectName  项目名称
     * @param projectType  项目分类
     * @param projectGroup 项目分组
     * @return
     */
    @GetMapping("/findcondition")
    public Result findCondition(@RequestParam(required = false) String projectName,
                                @RequestParam(required = false) String projectType,
                                @RequestParam(required = false) String projectGroup){
        List<Project> projects = projectService.findByCondition(projectName, projectType, projectGroup);
        if(projects != null && !projects.isEmpty()){
            return new Result("success","返回成功",projects);
        }else{
            return new Result("error","返回失败");
        }
    }

    /**
     * 按项目分类查找项目报价表
     * @param projectType
     * @return
     */

    @GetMapping("/findByType")
    public Result findByType(@RequestParam String projectType){
        List<Project> projects = projectService.findByProjectType(projectType);
        if(projects != null && !projects.isEmpty()){
            return new Result("success","返回成功",projects);
        }else{
            return new Result("error","返回失败");
        }
    }

}
