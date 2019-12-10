package com.rgy.rgy.dao;

import com.rgy.rgy.bean.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaterialDao extends JpaRepository<Material,Integer> {
    List<Material> findByMaterialNameLike(String name);

    @Query("select a from Material a where a.materialID=?1")
    Material findByGID(int id);

}
