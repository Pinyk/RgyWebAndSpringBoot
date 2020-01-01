package com.rgy.rgy.dao.daoToAndroid;

import com.rgy.rgy.bean.beanToAndroid.ContractComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractCommentDao extends JpaRepository<ContractComment,Integer> {

    //根据合同编号查询历史评论
    @Query(value = "select * from contract_comment where contract_id = ?1 ",nativeQuery = true)
    List<ContractComment> getContractCommentsByContractId(Integer contractId);



}
