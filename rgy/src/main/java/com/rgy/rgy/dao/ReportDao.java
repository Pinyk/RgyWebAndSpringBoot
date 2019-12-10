package com.rgy.rgy.dao;

import com.rgy.rgy.bean.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDao extends JpaRepository<Report,Integer>{
    Report findByReportName(String reportName);

    @Query(value = "select * from report where if(?1 !='',report_number=?1,1=1) and if(?2 !='',contract_id=?2,1=1)" +
            "and if(?3 !='',report_name=?3,1=1)  ",nativeQuery = true)
    List<Report> findByCondition(String X1, Integer X2, String X3);

    @Query("select a from Report a where a.reportId=?1")
    Report findByGId(Integer reportId);
}
