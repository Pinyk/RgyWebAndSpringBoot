package com.rgy.rgy.bean;

import lombok.*;
import lombok.Data;

import javax.persistence.*;

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
    private int projectId;

    @Column
    private String projectName;

    @Column
    private String projecType;

    @Column
    private String projectGroup;

    @Column
    private String unit;

    @Column
    private double s100MWPrice;

    @Column
    private double s100MWOverPrice;

    @Column
    private double h300MWPrice;

    @Column
    private double h600MWPrice;

    @Column
    private double h1000MWPrice;

    @Column
    private double d220KVPrice;

    @Column
    private double d500KVPrice;

    @Column
    private double d750KVPrice;

    @Column
    private double d50MWBelowPrice;



}
