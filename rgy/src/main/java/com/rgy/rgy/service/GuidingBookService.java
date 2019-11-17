package com.rgy.rgy.service;

/**
 * @Author：AnZhuJun
 * @Date: 2019/11/17 16:00
 */

import com.rgy.rgy.bean.GuidingBook;
import com.rgy.rgy.dao.GuidingBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuidingBookService {
    @Autowired
    GuidingBookDao guidingBookDao;

    public List<GuidingBook> findAll(){
        return guidingBookDao.findAll();
    }

    public void add(GuidingBook guidingBook){
        guidingBookDao.save(guidingBook);
    }

    public Boolean gdel(int guidingBookId){
        GuidingBook guidingBook = guidingBookDao.findByGuidingBookId(guidingBookId);
        if(guidingBook!=null){
            guidingBook.setInfoState(1);
            return true;
        }else {
            return false;
        }
    }

    public GuidingBook findByName(String name){
        return guidingBookDao.findByGuidingBookName(name);
    }
}
