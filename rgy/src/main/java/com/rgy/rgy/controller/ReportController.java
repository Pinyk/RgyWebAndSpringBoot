package com.rgy.rgy.controller;

import com.rgy.rgy.bean.Report;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 报告
 * @Author: gaoyk
 * @Date: 2019/11/3 21:00
 */
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    ReportService reportService;

    /**
     * 新增、修改报告
     * @param report
     * @return
     */
    @PostMapping("/add")
    public Result radd(@RequestBody Report report){
        int reportId = reportService.radd(report);
        if(reportId!=0){
            return new Result("success","新增成功",reportId);
        }else{
            return new Result("error","新增失败");
        }
    }

    /**
     * 返回所有报告
     * @return
     */
    @GetMapping("/returnall")
    public Result returnAll(){
        List<Report> reports = reportService.returnAll();
        if(reports!=null){
            return new Result("success","返回成功",reports);
        }else{
            return new Result("error","返回失败");
        }
    }

    /**
     * 使用名字查找
     * @param reportName
     * @return
     */
    @GetMapping("/findbyname")
    public Result findByName(@RequestParam String reportName){
        Report report = reportService.findByName(reportName);
        if (report==null){
            return new Result("success","查找成功",report);
        }
        return new Result("error","查找失败");
    }

    /**
     * 删除报告
     * @param report
     * @return
     */
    @GetMapping("/delete")
    public Result removeReport(@RequestBody Report report){
        if(reportService.deleteReport(report)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }
}
