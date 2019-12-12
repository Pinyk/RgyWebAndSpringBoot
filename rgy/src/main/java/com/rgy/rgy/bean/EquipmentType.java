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

    public Integer getEquipmentTypeID() {
        return equipmentTypeID;
    }

    public void setEquipmentTypeID(Integer equipmentTypeID) {
        this.equipmentTypeID = equipmentTypeID;
    }

    public String getEquipmentTypeName() {
        return equipmentTypeName;
    }

    public void setEquipmentTypeName(String equipmentTypeName) {
        this.equipmentTypeName = equipmentTypeName;
    }

    public Integer getInfoState() {
        return infoState;
    }

    public void setInfoState(Integer infoState) {
        this.infoState = infoState;
    }
}
