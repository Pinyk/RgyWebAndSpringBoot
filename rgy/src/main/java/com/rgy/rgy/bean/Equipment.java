package com.rgy.rgy.bean;

import lombok.*;
import lombok.Data;

import javax.persistence.*;


//设备
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int equipmentId;

    @Column
    private int equipmentTypeID;

    @Column
    private String equipmentName;

    @Column
    private int voltageLevel;

    @Column
    private String manufactorer;

    @Column
    private String equipmentModel;

    @Column
    private String runDate;

    @Column
    private String picUrl1;

    @Column
    private String picUrl2;

    @Column
    private String remarks;

    @Column
    private int infoState;
}
