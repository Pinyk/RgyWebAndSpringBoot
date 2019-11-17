package com.rgy.rgy.service;

import com.rgy.rgy.bean.Contract;
import com.rgy.rgy.bean.Material;
import com.rgy.rgy.dao.MaterialDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    MaterialDao materialDao;


    public List<Material> findAll(){
        return materialDao.findAll();
    }

    //根据人员资料名查询
    public List<Material> findByMaterialName(String name){
        return materialDao.findByMaterialName(name);
    }

    public int madd(String materialName, String materialUrl){
        materialDao.save(new Material(materialName,materialUrl));
        Material material = materialDao.findByMaterialNameAndAndMaterialUrl(materialName,materialUrl);
        return material.getMaterialID();
    }

    public void update(Material material){
        materialDao.save(material);
    }

    public Boolean cdel(int contractId){
        Material material = materialDao.findByMaterialID(contractId);
        if(material!=null){
            materialDao.delete(material);
            return true;
        }else {
            return false;
        }
    }
}
