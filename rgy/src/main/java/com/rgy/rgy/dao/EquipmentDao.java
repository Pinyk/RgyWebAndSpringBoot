package com.rgy.rgy.dao;


import com.rgy.rgy.bean.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentDao extends JpaRepository<Equipment,Integer> {
    @Query(value = "select * from equipment where if(?1 !='',equipment_name=?1,1=1) and if(?2 !='',equipment_typeid=?2,1=1)" +
            "and if(?3 !='',voltage_level=?3,1=1)  " + "and if(?4 !='',power_plantid=?4,1=1)  ",nativeQuery = true)
    List<Equipment> findbyCondition(String X1, String X2, String X3, Integer X4);

    List<Equipment> findByPowerPlantID(Integer powerPlantID);

    Equipment findByEquipmentId(Integer equipmentId);
}
