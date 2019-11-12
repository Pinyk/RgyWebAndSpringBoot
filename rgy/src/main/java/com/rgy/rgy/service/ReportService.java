package com.rgy.rgy.service;

import com.rgy.rgy.bean.Report;
import com.rgy.rgy.dao.ReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Author: gaoyk
 * @Date: 2019/10/30 21:05
 */

@Service
public class ReportService {
    @Autowired
    ReportDao reportDao;

    public int radd(Report report){
        Report report1 = reportDao.save(report);
        return report1.getReportId();
    }

    public List<Report> returnAll(){
        List<Report> reports = reportDao.findAll();
        return reports;
    }

    public Report findByName(String reportName){
        return reportDao.findByReportName(reportName);
    }

    public boolean deleteReport(Report report) {
        String msg = report.getReportName();
        reportDao.delete(report);
        if(reportDao.findByReportName(msg)==null){
            return true;
        }else{
            return false;
        }
    }
}
