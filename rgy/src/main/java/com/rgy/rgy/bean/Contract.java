package com.rgy.rgy.bean;

import lombok.*;
import lombok.Data;

import javax.persistence.*;

/**
 * @Author：AnZhuJun
 * @Date: 2019/11/14 15:00
 */


//合同
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "contract")
public class Contract {
    //合同id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contractId;

    //合同编号
    @Column
    private String contractNumber;

    //合同名称
    @Column
    private String contractName;

    //合同金额
    @Column
    private Double contractAmount;

    //币种
    @Column
    private String currency;

    //业务员
    @Column
    private String salesMan;

    //合同年限
    @Column
    private String signYear;

    //签订日期
    @Column
    private String signDate;

    //合同所属区域
    @Column
    private String contractArea;

    //合同业务类型
    @Column
    private String businessType;

    //合同内容概述
    @Column
    private String overview;

    //合同文本
    @Column
    private String contractText;

    //合同异常情况备注
    @Column
    private String abnormalNote;

    //合同甲方
    @Column
    private String partyA;

    //合同甲方地址
    @Column
    private String partyAAddress;

    //合同甲方联系人
    @Column
    private String partyALinkman;

    //合同甲方联系人电话
    @Column
    private String partyAPhone;

    //合同甲方联系人Email
    @Column
    private String partyAEmail;

    //合同乙方
    @Column
    private String partyB;

//    合同乙方联系人地址
//    @Column
//    private String partyBAddress;

    //合同乙方联系人
    @Column
    private String partyBLinkman;

    //合同乙方联系人电话
    @Column
    private String partyBPhone;

    //合同乙方联系人Email
    @Column
    private String partyBEmail;

    //合同执行责任部门
    @Column
    private String executiveDept;

    //执行开始日期
    @Column
    private String executiveStartDate;

    //执行截至日期
    @Column
    private String executiveEndDate;

    //项目负责人
    @Column
    private String projectManager;

    //项目执行人员
    @Column
    private String projectExecutive;

    //技术报告编号
    @Column
    private String reportNumber;

    //技术报告文档
    @Column
    private String reportUrl;

    //技术报告邮寄日期
    @Column
    private String reportMailingDate;

    //开具发票金额
    @Column
    private Double lnvoiceAmount;

    //开具发票日期
    @Column
    private String lnvoiceDate;

    //开具收据日期
    @Column
    private String receiptDate;

    //发票,收据邮寄日期
    @Column
    private String mailingDate;

    //开局发票,收据详情备注
    @Column
    private String detailsNote;

    //发票收件人地址
    @Column
    private String receiverAddress;

    //发票收件人姓名
    @Column
    private String receiverName;

    //发票收件人电话
    @Column
    private String receiverPhone;

    //回款金额
    @Column
    private Double paymentAmount;

    //回款日期
    @Column
    private String paymentDate;

    //回款余额
    @Column
    private Double paybackBalance;

    //回款详情备注
    @Column
    private String paymentNote;

    //状态
    @Column
    private Integer infoState;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(String salesMan) {
        this.salesMan = salesMan;
    }

    public String getSignYear() {
        return signYear;
    }

    public void setSignYear(String signYear) {
        this.signYear = signYear;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getContractArea() {
        return contractArea;
    }

    public void setContractArea(String contractArea) {
        this.contractArea = contractArea;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getContractText() {
        return contractText;
    }

    public void setContractText(String contractText) {
        this.contractText = contractText;
    }

    public String getAbnormalNote() {
        return abnormalNote;
    }

    public void setAbnormalNote(String abnormalNote) {
        this.abnormalNote = abnormalNote;
    }

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }

    public String getPartyAAddress() {
        return partyAAddress;
    }

    public void setPartyAAddress(String partyAAddress) {
        this.partyAAddress = partyAAddress;
    }

    public String getPartyALinkman() {
        return partyALinkman;
    }

    public void setPartyALinkman(String partyALinkman) {
        this.partyALinkman = partyALinkman;
    }

    public String getPartyAPhone() {
        return partyAPhone;
    }

    public void setPartyAPhone(String partyAPhone) {
        this.partyAPhone = partyAPhone;
    }

    public String getPartyAEmail() {
        return partyAEmail;
    }

    public void setPartyAEmail(String partyAEmail) {
        this.partyAEmail = partyAEmail;
    }

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }

    public String getPartyBLinkman() {
        return partyBLinkman;
    }

    public void setPartyBLinkman(String partyBLinkman) {
        this.partyBLinkman = partyBLinkman;
    }

    public String getPartyBPhone() {
        return partyBPhone;
    }

    public void setPartyBPhone(String partyBPhone) {
        this.partyBPhone = partyBPhone;
    }

    public String getPartyBEmail() {
        return partyBEmail;
    }

    public void setPartyBEmail(String partyBEmail) {
        this.partyBEmail = partyBEmail;
    }

    public String getExecutiveDept() {
        return executiveDept;
    }

    public void setExecutiveDept(String executiveDept) {
        this.executiveDept = executiveDept;
    }

    public String getExecutiveStartDate() {
        return executiveStartDate;
    }

    public void setExecutiveStartDate(String executiveStartDate) {
        this.executiveStartDate = executiveStartDate;
    }

    public String getExecutiveEndDate() {
        return executiveEndDate;
    }

    public void setExecutiveEndDate(String executiveEndDate) {
        this.executiveEndDate = executiveEndDate;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getProjectExecutive() {
        return projectExecutive;
    }

    public void setProjectExecutive(String projectExecutive) {
        this.projectExecutive = projectExecutive;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    public String getReportMailingDate() {
        return reportMailingDate;
    }

    public void setReportMailingDate(String reportMailingDate) {
        this.reportMailingDate = reportMailingDate;
    }

    public Double getLnvoiceAmount() {
        return lnvoiceAmount;
    }

    public void setLnvoiceAmount(Double lnvoiceAmount) {
        this.lnvoiceAmount = lnvoiceAmount;
    }

    public String getLnvoiceDate() {
        return lnvoiceDate;
    }

    public void setLnvoiceDate(String lnvoiceDate) {
        this.lnvoiceDate = lnvoiceDate;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getMailingDate() {
        return mailingDate;
    }

    public void setMailingDate(String mailingDate) {
        this.mailingDate = mailingDate;
    }

    public String getDetailsNote() {
        return detailsNote;
    }

    public void setDetailsNote(String detailsNote) {
        this.detailsNote = detailsNote;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getPaybackBalance() {
        return paybackBalance;
    }

    public void setPaybackBalance(Double paybackBalance) {
        this.paybackBalance = paybackBalance;
    }

    public String getPaymentNote() {
        return paymentNote;
    }

    public void setPaymentNote(String paymentNote) {
        this.paymentNote = paymentNote;
    }

    public Integer getInfoState() {
        return infoState;
    }

    public void setInfoState(Integer infoState) {
        this.infoState = infoState;
    }
}
