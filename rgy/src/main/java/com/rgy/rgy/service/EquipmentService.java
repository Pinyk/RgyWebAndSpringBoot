package com.rgy.rgy.service;

import com.rgy.rgy.bean.Equipment;
import com.rgy.rgy.dao.EquipmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: gaoyk
 * @Date: 2019/11/1 23:22
 */

@Service
public class EquipmentService{
    @Autowired
    EquipmentDao equipmentDao;

    public Boolean add(Equipment equipment) {
        Equipment equipment1 = equipmentDao.save(equipment);
        if(equipment1 != null){
            return true;
        }else{
            return false;
        }
    }

    public List<Equipment> findALl(){
        return equipmentDao.findAll();
    }

    public List<Equipment> findByCondition(String equipmentName,
                                           String equipmentTypeID,
                                           String voltageLevel) {
        return equipmentDao.findbyCondition(equipmentName,equipmentTypeID,voltageLevel);
    }

    public List<Equipment> findByPowerPlantId(Integer powerPlantID) {
        return equipmentDao.findByPowerPlantID(powerPlantID);
    }

    public boolean update(Equipment equipment) {
        Equipment equipment1 = equipmentDao.findByEquipmentId(equipment.getEquipmentId());
        if(equipment1 == null){
            return false;
        }
        equipment1 = equipment;
        if(equipmentDao.save(equipment1) != null){
            return true;
        }else{
            return false;
        }
    }

    public boolean delete(Integer equipmentId) {
        Equipment equipment = equipmentDao.findByEquipmentId(equipmentId);
        if(equipment != null){
            equipment.setEquipmentId(1);
            equipmentDao.save(equipment);
            return true;
        }else{
            return false;
        }
    }
}
