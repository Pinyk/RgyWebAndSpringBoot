package com.rgy.rgy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: gaoyk
 * @Date: 2019/11/6 14:50
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "datas")
public class Datas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "datasId")
    private Integer datasId;

    @OneToOne(targetEntity = Report.class)
    @JoinColumn(name = "reportId")
    private Integer reportId;

    @Column
    private String powerPlantName;

    @Column
    private Integer templateId;

    @Column
    private Integer paramsId;

    @Column
    private Integer equipmentId;

    @Column
    private String Datasvalue;
}
