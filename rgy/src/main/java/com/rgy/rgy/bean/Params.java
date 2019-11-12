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

    @ManyToOne(targetEntity = Items.class)
    @JoinColumn(name = "itemsId")
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
}
