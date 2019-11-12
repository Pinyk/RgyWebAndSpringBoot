package com.rgy.rgy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//电厂信息
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "power_plant")
public class PowerPlant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer powerPlantID;

    @Column
    private String powerPlantName;

    @Column
    private String powerPlantType;

    @Column
    private String generatorCapacity;

    @Column
    private String voltageLevel;

    @Column
    private String province;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String postcode;

    @Column
    private Integer infoState;
}
