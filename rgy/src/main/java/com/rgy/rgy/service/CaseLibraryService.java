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


    public boolean add(CaseLibrary caseLibrary){
        return caseLibraryDao.save(caseLibrary) != null ;
    }

    public boolean update(CaseLibrary caseLibrary){
        return caseLibraryDao.save(caseLibrary) != null ;
    }


    public boolean delete(Integer id){
        CaseLibrary caseLibrary = caseLibraryDao.findByCaseLibraryID(id);
        if(caseLibrary != null) {
            caseLibraryDao.deleteById(id);
            return true;
        }
        return false;
    }
}
