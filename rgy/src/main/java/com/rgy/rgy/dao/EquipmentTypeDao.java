package com.rgy.rgy.dao;

import com.rgy.rgy.bean.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentTypeDao extends JpaRepository<EquipmentType,Integer> {
    List<EquipmentType> findByEquipmentTypeName(String name);


    EquipmentType findByEquipmentTypeID(Integer EquipmentTypeID);
}
