package com.rgy.rgy.bean;

//检测项目表

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Items implements Comparable<Items>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemsId")
    private Integer itemsId;

    @Column
    private Integer templateId;

    @Column
    private String itemsName;

    @Column
    private Integer sort;

    @Column
    private Integer infoState;

    public Items(Integer templateId, String itemsName, Integer sort, Integer infoState) {
        this.templateId = templateId;
        this.itemsName = itemsName;
        this.sort = sort;
        this.infoState = infoState;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public String getItemsName() {
        return itemsName;
    }

    public void setItemsName(String itemsName) {
        this.itemsName = itemsName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getInfoState() {
        return infoState;
    }

    public void setInfoState(Integer infoState) {
        this.infoState = infoState;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    @Override
    public int compareTo(Items o) {
        int i = this.sort - o.getSort();
        return i;
    }
}
