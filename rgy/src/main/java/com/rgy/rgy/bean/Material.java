package com.rgy.rgy.bean;

import javax.persistence.*;

//实验人员资料管理
@Entity
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int materialID;

    @Column
    private String materialName;

    @Column(name = "materialUrl")
    private String materialUrl;

    public Material(int materialID, String materialName, String materialUrl) {
        this.materialID = materialID;
        this.materialName = materialName;
        this.materialUrl = materialUrl;
    }

    public Material() {
    }

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialUrl() {
        return materialUrl;
    }

    public void setMaterialUrl(String materialUrl) {
        this.materialUrl = materialUrl;
    }
}
