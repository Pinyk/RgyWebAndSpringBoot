package com.rgy.rgy.dao;

import com.rgy.rgy.bean.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsDao extends JpaRepository<Items,Integer> {
    Items findByItemsName(String itemsName);
    Items findByItemsId(int itemsId);
}
