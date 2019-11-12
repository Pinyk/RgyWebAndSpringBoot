package com.rgy.rgy.dao;


import com.rgy.rgy.bean.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractDao extends JpaRepository<Contract,Integer> {
}
