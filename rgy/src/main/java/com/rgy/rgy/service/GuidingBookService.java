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

    public boolean add(GuidingBook guidingBook){
        guidingBook.setInfoState(0);
        GuidingBook guidingBook1 = guidingBookDao.save(guidingBook);
        if (guidingBook1 != null){
            return true;
        }else{
            return false;
        }
    }

    public Boolean delete(int guidingBookId){
        GuidingBook guidingBook = guidingBookDao.findByGuidingBookId(guidingBookId);
        if(guidingBook!=null){
            guidingBook.setInfoState(1);
            guidingBookDao.save(guidingBook);
            return true;
        }else {
            return false;
        }
    }

    public boolean update(GuidingBook guidingBook){
        GuidingBook guidingBook1 = guidingBookDao.findByGuidingBookId(guidingBook.getGuidingBookId());
        if (guidingBook1 == null)
            return false;
        guidingBook1 = guidingBook;
        if (guidingBookDao.save(guidingBook1) != null){
            return true;
        }else {
            return false;
        }
    }

    public List<GuidingBook> findByName(String name){
        return guidingBookDao.findByGuidingBookName(name);
    }
}
