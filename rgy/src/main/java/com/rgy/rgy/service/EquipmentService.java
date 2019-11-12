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

    public void add(Equipment equipment) {
        equipmentDao.save(equipment);
    }

    public List<Equipment> findALl(){
        return equipmentDao.findAll();
    }

    public List<Equipment> findByCondition(String equipmentName,
                                           String equipmentTypeID,
                                           String voltageLevel) {
        return equipmentDao.findbyCondition(equipmentName,equipmentTypeID,voltageLevel);
    }
}
