package com.rgy.rgy.service;

/**
 * @Author：AnZhuJun
 * @Date: 2019/11/17 16:00
 */

import com.rgy.rgy.bean.GuidingBook;
import com.rgy.rgy.dao.GuidingBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GuidingBookService {
    @Autowired
    GuidingBookDao guidingBookDao;

    public List<GuidingBook> findAll(){
        return guidingBookDao.findAll();
    }

    public boolean add(String guidingBookName,String guidingBookUrl){
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String uploadDate = sf.format(date);
        GuidingBook guidingBook = new GuidingBook(guidingBookName,guidingBookUrl,uploadDate);
        guidingBook.setInfoState(0);
        if(guidingBookDao.save(guidingBook) != null){
            return true;
        }else{
            return false;
        }
    }

    public Boolean delete(int guidingBookId){
        GuidingBook guidingBook = guidingBookDao.findByGId(guidingBookId);
        if(guidingBook!=null){
            guidingBook.setInfoState(1);
            guidingBookDao.save(guidingBook);
            return true;
        }else {
            return false;
        }
    }

    public boolean update(GuidingBook guidingBook){
        GuidingBook guidingBook1 = guidingBookDao.findByGId(guidingBook.getGuidingBookId());
        if (guidingBook1 == null)
            return false;
        guidingBook1 = guidingBook;
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String uploadDate = sf.format(date);
        guidingBook1.setUploadDate(uploadDate);
        if (guidingBookDao.save(guidingBook1) != null){
            return true;
        }else {
            return false;
        }
    }

    public List<GuidingBook> findByName(String name){
        return guidingBookDao.findByGuidingBookName(name);
    }

    public List<GuidingBook> findByKeywordLike(String guidingBookName) {
        return guidingBookDao.findByGuidingBookNameLike("%"+guidingBookName+"%");
    }
}
