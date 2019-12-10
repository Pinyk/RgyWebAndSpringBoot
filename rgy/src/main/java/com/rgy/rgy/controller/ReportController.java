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

@CrossOrigin
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    ReportService reportService;

    /**
     * 新增报告
     * @param report
     * @return
     */
    @PostMapping("/add")
    public Result radd(@RequestBody Report report){
        Integer reportId = reportService.radd(report);
        if(reportId > 0){
            return new Result("success","新增成功",reportId);
        }else{
            return new Result("error","新增失败");
        }
    }

    /**
     * 更新
     * @param report
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody Report report){
        if(reportService.update(report)){
            return new Result("success","修改成功");
        }else{
            return new Result("error","修改失败");
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
     * 条件查找
     * @param reportNumber
     * @param contractId
     * @param reportName
     * @return
     */
    @GetMapping("/findCondition")
    public Result findByName(@RequestParam String reportNumber, @RequestParam  Integer contractId, @RequestParam String reportName){
        List<Report> reports = reportService.findByName(reportNumber,contractId,reportName);
        if (reports != null){
            return new Result("success","查找成功",reports);
        }
        return new Result("error","查找失败");
    }

    /**
     * 删除
     * @param reportId
     * @return
     */
    @GetMapping("/delete")
    public Result removeReport(@RequestParam Integer reportId){
        if(reportService.deleteReport(reportId)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }
}
