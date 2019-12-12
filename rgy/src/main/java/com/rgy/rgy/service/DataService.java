package com.rgy.rgy.service;

import com.rgy.rgy.bean.Datas;
import com.rgy.rgy.dao.DataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 实验数据
 * @Author: gaoyk
 * @Date: 2019/11/4 20:31
 */
@Service
public class DataService {
    @Autowired
    DataDao dataDao;

    public boolean add(List<Datas> datas) {
        for(Datas datas1 : datas){
            if(dataDao.save(datas1) == null){
                return false;
            }
        }
        return true;
    }

    public List<Datas> findall() {
        return dataDao.findAll();
    }
}




