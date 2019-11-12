package com.rgy.rgy.bean;

import javax.persistence.*;


//设备类型
@Entity
@Table(name = "equipment_type")
public class EquipmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int equipmentTypeID;

    @Column
    private String equipmentTypeName;

    @Column
    private String infoState;

    @Override
    public String toString() {
        return "EquipmentType{" +
                "equipmentTypeID=" + equipmentTypeID +
                ", equipmentTypeName='" + equipmentTypeName + '\'' +
                ", infoState='" + infoState + '\'' +
                '}';
    }

    public int getEquipmentTypeID() {
        return equipmentTypeID;
    }

    public void setEquipmentTypeID(int equipmentTypeID) {
        this.equipmentTypeID = equipmentTypeID;
    }

    public String getEquipmentTypeName() {
        return equipmentTypeName;
    }

    public void setEquipmentTypeName(String equipmentTypeName) {
        this.equipmentTypeName = equipmentTypeName;
    }

    public String getInfoState() {
        return infoState;
    }

    public void setInfoState(String infoState) {
        this.infoState = infoState;
    }

    public EquipmentType(int equipmentTypeID, String equipmentTypeName, String infoState) {
        this.equipmentTypeID = equipmentTypeID;
        this.equipmentTypeName = equipmentTypeName;
        this.infoState = infoState;
    }

    public EquipmentType(String equipmentTypeName, String infoState) {
        this.equipmentTypeName = equipmentTypeName;
        this.infoState = infoState;
    }

}
