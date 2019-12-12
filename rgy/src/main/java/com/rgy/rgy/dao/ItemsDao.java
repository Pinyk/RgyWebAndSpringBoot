package com.rgy.rgy.dao;

import com.rgy.rgy.bean.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsDao extends JpaRepository<Items,Integer> {
    Items findByItemsName(String itemsName);
    Items findByItemsId(int itemsId);

    List<Items> findByTemplateId(Integer TemplateId);
}
