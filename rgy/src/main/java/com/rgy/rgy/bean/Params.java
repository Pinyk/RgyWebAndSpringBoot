package com.rgy.rgy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//参数配置表
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "params")
public class Params {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paramsId")
    private Integer paramsId;

    private Integer itemsId;

    @Column
    private String paramsName;

    @Column
    private String paramsType;

    @Column
    private String quaOptionOne;

    @Column
    private String quaOptionTwo;

    @Column
    private String quaUnit;

    @Column
    private String quaUpperLim;

    @Column
    private String quaLowerLim;

    @Column
    private Integer infoState;

    public Integer getParamsId() {
        return paramsId;
    }

    public void setParamsId(Integer paramsId) {
        this.paramsId = paramsId;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public String getParamsName() {
        return paramsName;
    }

    public void setParamsName(String paramsName) {
        this.paramsName = paramsName;
    }

    public String getParamsType() {
        return paramsType;
    }

    public void setParamsType(String paramsType) {
        this.paramsType = paramsType;
    }

    public String getQuaOptionOne() {
        return quaOptionOne;
    }

    public void setQuaOptionOne(String quaOptionOne) {
        this.quaOptionOne = quaOptionOne;
    }

    public String getQuaOptionTwo() {
        return quaOptionTwo;
    }

    public void setQuaOptionTwo(String quaOptionTwo) {
        this.quaOptionTwo = quaOptionTwo;
    }

    public String getQuaUnit() {
        return quaUnit;
    }

    public void setQuaUnit(String quaUnit) {
        this.quaUnit = quaUnit;
    }

    public String getQuaUpperLim() {
        return quaUpperLim;
    }

    public void setQuaUpperLim(String quaUpperLim) {
        this.quaUpperLim = quaUpperLim;
    }

    public String getQuaLowerLim() {
        return quaLowerLim;
    }

    public void setQuaLowerLim(String quaLowerLim) {
        this.quaLowerLim = quaLowerLim;
    }

    public Integer getInfoState() {
        return infoState;
    }

    public void setInfoState(Integer infoState) {
        this.infoState = infoState;
    }
}
