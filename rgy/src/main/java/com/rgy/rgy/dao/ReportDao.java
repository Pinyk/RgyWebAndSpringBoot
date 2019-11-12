package com.rgy.rgy.dao;

import com.rgy.rgy.bean.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportDao extends JpaRepository<Report,Integer>{
    Report findByReportName(String reportName);
}
