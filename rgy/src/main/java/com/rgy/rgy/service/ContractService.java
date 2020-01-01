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

    public List<Contract> findByName(String contractName) {
        return contractDao.findByName(contractName);

    }
    public List<Contract> findByCondition(String contractName,Integer infoState,
                                          String businessType,
                                          String partyA,String partyB,
                                          String projectManager,String salesMan,
                                          String signDate,String executiveStartDate,
                                          String executiveEndDate) {
        return contractDao.findByCondition(contractName, infoState, businessType,
                partyA, partyB, projectManager, salesMan, signDate,executiveStartDate,
                executiveEndDate);

    }


    public boolean add(Contract contract){
        contract.setInfoState( 0 );
        String getExecutiveEndDate = contract.getExecutiveEndDate().substring(0,10);
        String getExecutiveStartDate = contract.getExecutiveStartDate().substring(0,10);
        String getLnvoiceDate = contract.getLnvoiceDate().substring(0,10);
        String getMailingDate = contract.getMailingDate().substring(0,10);
        String getSignDate = contract.getSignDate().substring(0,10);
        String getReceiptDate = contract.getReceiptDate().substring(0,10);
        String getPaymentDate = contract.getPaymentDate().substring(0,10);
        contract.setExecutiveEndDate(getExecutiveEndDate);
        contract.setExecutiveStartDate(getExecutiveStartDate);
        contract.setLnvoiceDate(getLnvoiceDate);
        contract.setMailingDate(getMailingDate);
        contract.setSignDate(getSignDate);
        contract.setReceiptDate(getReceiptDate);
        contract.setPaymentDate(getPaymentDate);
        Contract contract1 = contractDao.save( contract );
        if (contract1 != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean update(Contract contract){
        Contract contract1 = contractDao.findByContractId( contract.getContractId() );
        if (contract1 == null) {
            return false;
        }
        contract1 = contract;
        if (contractDao.save(contract1) != null){
            return true;
        }
        return false;
    }

    public Boolean delete(Integer contractId){
        Contract contract = contractDao.findByContractId(contractId);
        if(contract != null){
            contract.setInfoState(1);
            contractDao.save( contract );
            return true;
        }else {
            return false;
        }
    }

    public Contract findbyid(Integer contractId) {
        Contract contract1 = contractDao.findByContractId(contractId);
        return contract1;
    }

}
