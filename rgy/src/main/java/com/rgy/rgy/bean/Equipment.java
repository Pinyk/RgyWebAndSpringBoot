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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equipmentId;

    @Column
    private Integer equipmentTypeID;

    @Column
    private String equipmentName;

    @Column
    private String voltageLevel;

    @Column
    private String manuFactorer;

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
    private Integer powerPlantID;

    @Column
    private Integer infoState;
}
