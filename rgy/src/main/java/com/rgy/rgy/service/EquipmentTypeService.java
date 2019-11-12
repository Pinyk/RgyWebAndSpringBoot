package com.rgy.rgy.service;

import com.rgy.rgy.bean.EquipmentType;
import com.rgy.rgy.dao.EquipmentTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentTypeService {
    @Autowired
    EquipmentTypeDao equipmentTypeDao;

    public List<EquipmentType> findAll(){
        return equipmentTypeDao.findAll();
    }

    public EquipmentType findByName(String name){
        return equipmentTypeDao.findByEquipmentTypeName(name);
    }

    public void add(EquipmentType equipmentType){
        equipmentTypeDao.save(equipmentType);
    }

    public void update(EquipmentType equipmentType){
        equipmentTypeDao.save(equipmentType);
    }

    public EquipmentType delete(int id){
        EquipmentType current =equipmentTypeDao.findById(id).orElse(new EquipmentType(-1,"null","0"));
        if(current.getEquipmentTypeID() > -1){
            equipmentTypeDao.deleteById(id);
        }
        return current;
    }


}
