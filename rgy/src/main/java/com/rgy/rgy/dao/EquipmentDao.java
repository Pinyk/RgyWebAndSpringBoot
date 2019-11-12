package com.rgy.rgy.dao;


import com.rgy.rgy.bean.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentDao extends JpaRepository<Equipment,Integer> {
}
