package com.rgy.rgy.dao;

/**
 * @Author：AnZhuJun
 * @Date: 2019/11/14 16:00
 */

import com.rgy.rgy.bean.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDao extends JpaRepository<Contract,Integer> {
    //通过合同名称,合同甲方,合同乙方,业务员,项目负责人,签订日期,执行开始日期,执行截至日期查询
    Contract findContractByContractNameAndPartyAAndPartyBAndSalesManAndProjectManagerAndSignDateAndExecutiveStartDateAndExecutiveEndDate(String contractName,String partyA,String partyB,String SalesMan,String ProjectManager,String SignDate,String ExecutiveStartDate,String ExecutiveEndDate);

    //通过合同名称查询
    List<Contract> findContractByContractName(String contractName);

    Contract findByContractId(int contractId);

}
