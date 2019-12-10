package com.rgy.rgy.bean;

import lombok.*;
import lombok.Data;

import javax.persistence.*;
import java.text.DecimalFormat;

//实验报价
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer projectId;

    @Column
    private String projectName;

    @Column
    private String projectType;

    @Column
    private String projectGroup;

    @Column
    private String unit;

    @Column
    private Double s100MWPrice;

    @Column
    private Double s100MWOverPrice;

    @Column
    private Double h300MWPrice;

    @Column
    private Double h600MWPrice;

    @Column
    private Double h1000MWPrice;

    @Column
    private Double d220KVPrice;

    @Column
    private Double d500KVPrice;

    @Column
    private Double d750KVPrice;

    @Column
    private Double d50MWBelowPrice;

    @Column
    private Double d100MWBelowPrice;

    @Column
    private Double d50MWOverPrice;

    @Column
    private Integer infoState;

}
