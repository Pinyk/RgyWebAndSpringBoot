package com.rgy.rgy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


//实验人员资料管理
@Data
@Entity
@Table(name = "material")
@AllArgsConstructor
@NoArgsConstructor
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer materialID;

    @Column
    private String materialName;

    @Column
    private String materialUrl;

    @Column
    private Integer infoState;


    public Material(String materialName, String materialUrl, Integer infoState) {
        this.materialName = materialName;
        this.materialUrl = materialUrl;
        this.infoState = infoState;
    }

    public Integer getMaterialID() {
        return materialID;
    }

    public void setMaterialID(Integer materialID) {
        this.materialID = materialID;
    }
}
