package com.rgy.rgy.service;
import com.rgy.rgy.bean.Items;
import com.rgy.rgy.dao.ItemsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @Author：gaoyk
 * @Date: 2019/10/31 22:02
 */

@Service
public class ItemsService {
    @Autowired
    ItemsDao itemsDao;

    public Boolean add(Items items ){
        items.setInfoState( 0 );
        Items save = itemsDao.save( items );
        if (save != null) {
            return true;
        } else {
            return false;
        }
    }

    public List<Items> findAll(){
        List<Items> all = itemsDao.findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get( i ).getInfoState() == 1) {
                all.remove( i );
                i--;
            }
        }
        return all;
    }

    public Boolean del(Integer itemsId){
        Items items = itemsDao.findByItemsId(itemsId);
        if(items!=null){
            items.setInfoState(1);
            itemsDao.save( items );

            return true;
        }else{
            return false;
        }
    }
}
