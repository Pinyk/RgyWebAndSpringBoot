package com.rgy.rgy.service;

import com.rgy.rgy.bean.CaseLibrary;
import com.rgy.rgy.dao.CaseLibraryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CaseLibraryService {
    @Autowired
    CaseLibraryDao caseLibraryDao;

    public List<CaseLibrary> findByKeywordLike(String keyword){
        return caseLibraryDao.findByKeywordLike("%"+keyword+"%");
    }
    public List<CaseLibrary> findAll(){
        return caseLibraryDao.findAll();
    }


    public boolean add(String keyword,String root){
        return caseLibraryDao.save(new CaseLibrary(keyword,root)) != null;
    }

    public boolean update(CaseLibrary caseLibrary){
        CaseLibrary caseLibrary1 = caseLibraryDao.findByCID(caseLibrary.getCaseLibraryID());
        if(caseLibrary1 == null){
            return false;
        }
        caseLibrary1 = caseLibrary;
        if(caseLibraryDao.save(caseLibrary1) != null){
            return true;
        }else{
            return false;
        }
    }


    public boolean delete(Integer id){
        CaseLibrary caseLibrary = caseLibraryDao.findByCID(id);
        if(caseLibrary != null) {
            caseLibraryDao.deleteById(id);
            return true;
        }
        return false;
    }
}
