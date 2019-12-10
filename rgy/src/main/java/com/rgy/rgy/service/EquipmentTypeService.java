package com.rgy.rgy.service;

import com.rgy.rgy.bean.Equipment;
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

    public boolean eadd(EquipmentType equipmentType){
        equipmentType.setInfoState(0);
        if(equipmentTypeDao.save(equipmentType) != null){
            return true;
        }else{
            return false;
        }
    }

    public List<EquipmentType> find(String equipmentTypeName){
        return equipmentTypeDao.findByEquipmentTypeName(equipmentTypeName);
    }

    public boolean update(EquipmentType equipmentType) {
        EquipmentType equipmentType1 =
                equipmentTypeDao.findByEquipmentTypeID(equipmentType.getEquipmentTypeID());
        if(equipmentType1 == null){
            return false;
        }
        equipmentType.setInfoState(0);
        equipmentType1 = equipmentType;
        if(equipmentTypeDao.save(equipmentType1) != null){
            equipmentTypeDao.findByEquipmentTypeID(equipmentType1.getEquipmentTypeID()).setInfoState(0);
            return true;
        }else{
            return false;
        }
    }

    public boolean delete(Integer equipmentTypeID) {
        EquipmentType equipmentType = equipmentTypeDao.findByEquipmentTypeID(equipmentTypeID);
        if(equipmentType != null){
            equipmentType.setInfoState(1);
            equipmentTypeDao.save(equipmentType);
            return true;
        }else{
            return false;
        }
    }

    public EquipmentType findById(Integer equipmentTypeID) {
        return equipmentTypeDao.findByEquipmentTypeID(equipmentTypeID);
    }
}
