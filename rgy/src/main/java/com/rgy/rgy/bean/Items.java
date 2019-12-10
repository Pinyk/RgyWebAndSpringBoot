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
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemsId")
    private Integer itemsId;

//    @ManyToOne(targetEntity = Template.class)
//    @JoinColumn(name = "templateId",columnDefinition = "itemsId")
    private Integer templateId;

    @Column
    private String itemsName;

    @Column
    private String sort;

    @Column
    private Integer infoState;

    public Items(int templateId, String itemsName, String sort, int infoState) {
        this.templateId = templateId;
        this.itemsName = itemsName;
        this.sort = sort;
        this.infoState = infoState;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }


    public Integer getItemsId() {
        return itemsId;
    }
}

//    private Integer itemsId;
//
//    @ManyToOne(targetEntity = Template.class)
//    @JoinColumn(name = "templateId",columnDefinition = "itemsId")
//    private Integer templateId;
//
//    @Column
//    private String itemsName;
//
//    @Column
//    private String sort;
//
//    @Column
//    private Integer infoState;
//
//    public Items(int templateId, String itemsName, String sort, int infoState) {
//        this.templateId = templateId;
//        this.itemsName = itemsName;
//        this.sort = sort;
//        this.infoState = infoState;
//    }
//
//    public void setTemplateId(Integer templateId) {
//        this.templateId = templateId;
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "itemsId")
//    public Integer getItemsId() {
//        return itemsId;
//    }
