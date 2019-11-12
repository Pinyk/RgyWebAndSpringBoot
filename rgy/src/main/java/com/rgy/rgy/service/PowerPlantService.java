package com.rgy.rgy.service;


import com.rgy.rgy.bean.PowerPlant;
import com.rgy.rgy.dao.PowerPlantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: gaoyk
 * @Date: 11/8  13:38
 */

@Service
public class PowerPlantService {
    @Autowired
    PowerPlantDao powerPlantDao;

    public boolean add(PowerPlant powerPlant) {
        powerPlant.setInfoState(0);
        PowerPlant powerPlant1 = powerPlantDao.save(powerPlant);
        if(powerPlant1 != null){
            return true;
        }else{
            return false;
        }
    }

    public boolean delete(String powerPlantName){
        PowerPlant powerPlant = powerPlantDao.findByPowerPlantName(powerPlantName);
        if(powerPlant != null){
            powerPlant.setInfoState(1);
            return true;
        }else{
            return false;
        }
    }

    public List<PowerPlant> findAll(){
        return powerPlantDao.findAll();
    }

    public List<PowerPlant> findByCondition(String powerPlantName, String powerPlantType,
                                            String generatorCapacity, String voltageLevel){
        return powerPlantDao.findbyCondition(powerPlantName,
                powerPlantType,generatorCapacity,voltageLevel);
    }
}
