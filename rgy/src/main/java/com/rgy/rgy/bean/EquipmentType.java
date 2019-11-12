package com.rgy.rgy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


//设备类型
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "equipment_type")
public class EquipmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equipmentTypeID;

    @Column
    private String equipmentTypeName;

    @Column
    private Integer infoState;

    public EquipmentType(String equipmentTypeName, Integer infoState) {
        this.equipmentTypeName = equipmentTypeName;
        this.infoState = infoState;
    }
}
