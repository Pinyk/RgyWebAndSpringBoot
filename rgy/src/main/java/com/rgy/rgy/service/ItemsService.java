package com.rgy.rgy.service;
import com.rgy.rgy.bean.Items;
import com.rgy.rgy.dao.ItemsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：gaoyk
 * @Date: 2019/10/31 22:02
 */

@Service
public class ItemsService {
    @Autowired
    ItemsDao itemsDao;

    public int iadd(String itemsName, String sort, int templateId){
        int infoState = 0;
        itemsDao.save(new Items(templateId,itemsName,sort,infoState));
        Items items = itemsDao.findByItemsName(itemsName);
        return items.getItemsId();
    }

    public List<Items> ireturnAll(){
        return itemsDao.findAll();
    }

    public Boolean idel(int itemsId){
        Items items = itemsDao.findByItemsId(itemsId);
        if(items!=null){
            items.setInfoState(1);
            return true;
        }else{
            return false;
        }
    }
}
