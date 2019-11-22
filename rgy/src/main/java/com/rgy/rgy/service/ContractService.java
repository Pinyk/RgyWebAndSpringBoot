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
        Contract contract1 = contractDao.save( contract );
        if (contract1 != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean update(Contract contract){
        Contract contract1 = contractDao.findByContractId( contract.getContractId() );
        if (contract1 != null) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean delete(int contractId){
        Contract contract = contractDao.findByContractId(contractId);
        if(contract != null){
            contract.setInfoState(1);
            contractDao.save( contract );
            return true;
        }else {
            return false;
        }
    }
}
