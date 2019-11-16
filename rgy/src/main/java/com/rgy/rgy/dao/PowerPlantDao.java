package com.rgy.rgy.dao;


import com.rgy.rgy.bean.PowerPlant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: gaoyk
 * @Date: 11/8  13:38
 */

@Repository
public interface PowerPlantDao extends JpaRepository<PowerPlant,Integer>{
    PowerPlant findByPowerPlantName(String powerPlantName);
    @Query(value = "select * from power_plant where if(?1 !='',power_plant_name=?1,1=1) and if(?2 !='',power_plant_type=?2,1=1)" +
            "and if(?3 !='',generator_capacity=?3,1=1)  " + "and if(?4 !='',voltage_level=?4,1=1)  ",nativeQuery = true)

    List<PowerPlant> findbyCondition(String X1, String X2, String X3, String X4);

    @Query("select a from PowerPlant a where a.powerPlantID=?1")
    PowerPlant findByid(Integer powerPlantID);

}
