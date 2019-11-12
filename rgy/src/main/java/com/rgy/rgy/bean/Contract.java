package com.rgy.rgy.bean;

import lombok.*;
import lombok.Data;

import javax.persistence.*;

//合同
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contractId;

    @Column
    private String contractNumber;

    @Column
    private String contractName;

    @Column
    private double contractAmount;

    @Column
    private String currency;

    @Column
    private String salesMan;

    @Column
    private String signYear;

    @Column
    private String signDate;

    @Column
    private String contractArea;

    @Column
    private String businessType;

    @Column
    private String overview;

    @Column
    private String contractText;

    @Column
    private String abnormalNote;

    @Column
    private String partyA;

    @Column
    private String partyAAddress;

    @Column
    private String partyALinkman;

    @Column
    private String partyAPhone;

    @Column
    private String partyAEmail;

    @Column
    private String partyB;

    @Column
    private String partyBAddress;

    @Column
    private String partyBLinkman;

    @Column
    private String partyBPhone;

    @Column
    private String partyBEmail;

    @Column
    private String executiveDept;

    @Column
    private String executiveStartDate;

    @Column
    private String executiveEndDate;

    @Column
    private String projectManager;

    @Column
    private String projectExecutive;

    @Column
    private String reportNumber;

    @Column
    private String reportUrl;

    @Column
    private String reportMailingDate;

    @Column
    private double lnvoiceAmount;

    @Column
    private String lnvoiceDate;

    @Column
    private String receiptDate;

    @Column
    private String mailingDate;

    @Column
    private String detailsNote;

    @Column
    private String receiverAddress;

    @Column
    private String receiverName;

    @Column
    private String receiverPhone;

    @Column
    private double paymentAmount;

    @Column
    private String paymentDate;

    @Column
    private double paybackBalance;

    @Column
    private String paymentNote;

    @Column
    private int infoState;
}
