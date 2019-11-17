package com.rgy.rgy.dao;

import com.rgy.rgy.bean.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialDao extends JpaRepository<Material,Integer> {
    List<Material> findByMaterialName(String name);
    Material findByMaterialNameAndAndMaterialUrl(String name,String url);
    Material findByMaterialID(int id);
}
