package com.rgy.rgy.service;


import com.rgy.rgy.bean.PowerPlant;
import com.rgy.rgy.dao.PowerPlantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public boolean update(PowerPlant powerPlant){
        PowerPlant powerPlant1 = powerPlantDao.findByid(powerPlant.getPowerPlantID());
        if(powerPlant1 == null){
            return false;
        }
        powerPlant1 = powerPlant;
        if (powerPlantDao.save(powerPlant1) != null){
            return true;
        }
        return false;
    }

    public boolean delete(Integer powerPlantID){
        PowerPlant powerPlant = powerPlantDao.findByid(powerPlantID);
        if(powerPlant != null){
            powerPlant.setInfoState(1);
            powerPlantDao.save(powerPlant);
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

    public List<List<PowerPlant>> findByType(){
        List<List<PowerPlant>> listList = new ArrayList<>();
        listList.add(powerPlantDao.findByPowerPlantType("火电厂"));
        listList.add(powerPlantDao.findByPowerPlantType("水电厂"));
        listList.add(powerPlantDao.findByPowerPlantType("风电厂"));
        listList.add(powerPlantDao.findByPowerPlantType("新能源"));
        return listList;
    }
}
