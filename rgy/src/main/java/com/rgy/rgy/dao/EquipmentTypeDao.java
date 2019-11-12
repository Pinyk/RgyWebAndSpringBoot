package com.rgy.rgy.dao;

import com.rgy.rgy.bean.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentTypeDao extends JpaRepository<EquipmentType,Integer> {
    EquipmentType findByEquipmentTypeName(String name);
}
