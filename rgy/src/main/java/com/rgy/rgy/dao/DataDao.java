package com.rgy.rgy.dao;


import com.rgy.rgy.bean.Datas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataDao extends JpaRepository<Datas,Integer> {
}
