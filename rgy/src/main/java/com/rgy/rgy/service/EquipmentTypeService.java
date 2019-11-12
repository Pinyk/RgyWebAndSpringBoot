package com.rgy.rgy.service;

import com.rgy.rgy.bean.EquipmentType;
import com.rgy.rgy.dao.EquipmentTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: gaoyk
 * @Date: 2019/10/27 11:15
 */

@Service
public class EquipmentTypeService {
    @Autowired
    EquipmentTypeDao equipmentTypeDao;

    public List<EquipmentType> findAll(){
        return equipmentTypeDao.findAll();
    }

    public void eadd(String equipmentTypeName){
        equipmentTypeDao.save(new EquipmentType(equipmentTypeName,0));
    }

    public EquipmentType find(String equipmentTypeName){
        return equipmentTypeDao.findByEquipmentTypeName(equipmentTypeName);
    }

    public EquipmentType findById(Integer equipmentTypeID){
        return equipmentTypeDao.findByEquipmentTypeID(equipmentTypeID);
    }
}
