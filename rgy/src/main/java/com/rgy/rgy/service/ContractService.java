package com.rgy.rgy.service;

import com.rgy.rgy.bean.Contract;
import com.rgy.rgy.dao.ContractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：AnZhuJun
 * @Date: 2019/11/14 16:30
 */

@Service
public class ContractService {
    @Autowired
    ContractDao contractDao;

    public List<Contract> findAll(){
        return contractDao.findAll();
    }

    public List<Contract> findContractByContractName(String contractName){
        return contractDao.findContractByContractName(contractName);
    }

    public Contract findContractByContractNameAndPartyAAndPartyBAndSalesManAndProjectManagerAndSignDateAndExecutiveStartDateAndExecutiveEndDate(String contractName,String partyA,String partyB,String SalesMan,String ProjectManager,String SignDate,String ExecutiveStartDate,String ExecutiveEndDate){
        return contractDao.findContractByContractNameAndPartyAAndPartyBAndSalesManAndProjectManagerAndSignDateAndExecutiveStartDateAndExecutiveEndDate(contractName, partyA, partyB, SalesMan, ProjectManager, SignDate, ExecutiveStartDate, ExecutiveEndDate);
    }

    public int cadd(String contractNumber, String contractName, double contractAmount, String currency, String salesMan, String signYear, String signDate, String contractArea, String businessType, String overview, String contractText, String abnormalNote, String partyA, String partyAAddress, String partyALinkman, String partyAPhone, String partyAEmail, String partyB, String partyBLinkman, String partyBPhone, String partyBEmail, String executiveDept, String executiveStartDate, String executiveEndDate, String projectManager, String projectExecutive, String reportNumber, String reportUrl, String reportMailingDate, double lnvoiceAmount, String lnvoiceDate, String receiptDate, String mailingDate, String detailsNote, String receiverAddress, String receiverName, String receiverPhone, double paymentAmount, String paymentDate, double paybackBalance, String paymentNote){
        int infoState = 0;
        contractDao.save(new Contract( contractNumber,  contractName,  contractAmount,  currency,  salesMan,  signYear, signDate,  contractArea,  businessType,  overview,  contractText,  abnormalNote,  partyA,  partyAAddress,  partyALinkman,  partyAPhone,  partyAEmail,  partyB,  partyBLinkman,  partyBPhone,  partyBEmail,  executiveDept,  executiveStartDate,  executiveEndDate,  projectManager,  projectExecutive,  reportNumber,  reportUrl,  reportMailingDate,  lnvoiceAmount,  lnvoiceDate, receiptDate,  mailingDate,  detailsNote,  receiverAddress,  receiverName,  receiverPhone,  paymentAmount,  paymentDate,  paybackBalance,paymentNote,0));
        Contract contract = contractDao.findContractByContractNameAndPartyAAndPartyBAndSalesManAndProjectManagerAndSignDateAndExecutiveStartDateAndExecutiveEndDate(
                contractName,
                partyA,
                partyB,
                salesMan,
                projectManager,
                signDate,
                executiveStartDate,
                executiveEndDate);
        return contract.getContractId();
    }

    public void cupdate(String contractNumber, String contractName, double contractAmount, String currency, String salesMan, String signYear, String signDate, String contractArea, String businessType, String overview, String contractText, String abnormalNote, String partyA, String partyAAddress, String partyALinkman, String partyAPhone, String partyAEmail, String partyB, String partyBLinkman, String partyBPhone, String partyBEmail, String executiveDept, String executiveStartDate, String executiveEndDate, String projectManager, String projectExecutive, String reportNumber, String reportUrl, String reportMailingDate, double lnvoiceAmount, String lnvoiceDate, String receiptDate, String mailingDate, String detailsNote, String receiverAddress, String receiverName, String receiverPhone, double paymentAmount, String paymentDate, double paybackBalance, String paymentNote){
        contractDao.save(new Contract( contractNumber,  contractName,  contractAmount,  currency,  salesMan,  signYear, signDate,  contractArea,  businessType,  overview,  contractText,  abnormalNote,  partyA,  partyAAddress,  partyALinkman,  partyAPhone,  partyAEmail,  partyB,  partyBLinkman,  partyBPhone,  partyBEmail,  executiveDept,  executiveStartDate,  executiveEndDate,  projectManager,  projectExecutive,  reportNumber,  reportUrl,  reportMailingDate,  lnvoiceAmount,  lnvoiceDate, receiptDate,  mailingDate,  detailsNote,  receiverAddress,  receiverName,  receiverPhone,  paymentAmount,  paymentDate,  paybackBalance,paymentNote,0));
    }

    public Boolean cdel(int contractId){
        Contract contract = contractDao.findByContractId(contractId);
        if(contract!=null){
            contract.setInfoState(1);
            return true;
        }else {
            return false;
        }
    }
}
