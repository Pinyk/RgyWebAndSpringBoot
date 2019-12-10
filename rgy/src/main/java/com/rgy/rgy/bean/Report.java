package com.rgy.rgy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 报告管理表
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportId")
    private Integer reportId;

    @Column
    private String reportNumber;

    @Column
    private String reportName;

    @Column
    private Integer contractId;

    @Column
    private String responsibleUnit;

    @Column
    private String undertakeDept;

    @Column
    private String startDate;

    @Column
    private String endDate;

    @Column
    private String responsiblePerson;

    @Column
    private String workers;

    @Column
    private String editor;

    @Column
    private String reviewer;

    @Column
    private String approver;
}
