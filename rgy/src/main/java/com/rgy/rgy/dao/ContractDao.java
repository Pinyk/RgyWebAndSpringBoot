package com.rgy.rgy.dao;

/**
 * @Author：AnZhuJun
 * @Date: 2019/11/14 16:00
 */

import com.rgy.rgy.bean.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDao extends JpaRepository<Contract,Integer> {

    //通过合同名称查询
    List<Contract> findContractByContractName(String contractName);

    //通过ID查询
    Contract findByContractId(Integer contractId);

    //组合查询
    @Query(value = "select * from contract " +
            "where if(?1 != '', contract_name=?1,1=1) " +
            "and if(?2 != '', info_state=?2,1=1)" +
            "and if(?3 != '', business_type=?3,1=1)" +
            "and if(?4 != '', partya=?4,1=1)"+
            "and if(?5 != '', partyb=?5,1=1)"+
            "and if(?6 != '', project_manager=?6,1=1)"+
            "and if(?7 != '', sales_man=?7,1=1)"+
            "and if(?8 != '', sign_date=?8,1=1)"+
            "and if(?9 != '', executive_start_date=?9,1=1)"+
            "and if(?10!= '', executive_end_date=?10,1=1)", nativeQuery = true)
    List<Contract> findByCondition(String X1, Integer X2, String X3, String X4,
                                   String X5, String X6, String X7, String X8,
                                   String X9, String X10);


    @Query(value = "select * from contract where contract_name like %?1%",nativeQuery = true)
    List<Contract> findByName(String name);
}
