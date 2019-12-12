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

    public Integer radd(Report report){
        report.setStartDate(report.getStartDate().substring(0,10));
        report.setEndDate(report.getEndDate().substring(0,10));
        Report report1 = reportDao.save(report);
        return report1.getReportId();
    }

    public List<Report> returnAll(){
        List<Report> reports = reportDao.findAll();
        return reports;
    }

    public List<Report> findByName(String reportNumber, Integer contractId, String reportName){
        return reportDao.findByCondition(reportNumber,contractId,reportName);
    }

    public boolean deleteReport(Integer reportId) {
        reportDao.deleteById(reportId);
        if(reportDao.findById(reportId) == null){
            return true;
        }else{
            return false;
        }
    }

    public boolean update(Report report) {
        Report report1 = reportDao.findByGId(report.getReportId());
        if(report1 == null){
            return false;
        }
        report1 = report;
        report1.setStartDate(report1.getStartDate().substring(0,10));
        report1.setEndDate(report1.getEndDate().substring(0,10));
        if(reportDao.save(report1) != null){
            return true;
        }else{
            return false;
        }
    }
}
