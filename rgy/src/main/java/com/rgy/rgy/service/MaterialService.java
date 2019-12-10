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
        return materialDao.findByMaterialNameLike("%"+name+"%");
    }

    public boolean add(String materialName, String materialUrl){
        Material material = materialDao.save(new Material(materialName,materialUrl,0));
        if(material!=null){
            return true;
        }else{
            return false;
        }
    }

    public Boolean update(Material material){
        Material material1 = materialDao.findByGID(material.getMaterialID());
        if(material1 == null){
            return false;
        }
        material1 = material;
        if(materialDao.save(material1)!=null){
            return true;
        }else{
            return false;
        }
    }

    public Boolean cdel(Integer contractId){
        Material material = materialDao.findByGID(contractId);
        if(material != null){
            material.setInfoState(1);
            materialDao.save(material);
            return true;
        }else {
            return false;
        }
    }
}
