package com.rgy.rgy.service;
import com.rgy.rgy.bean.Params;
import com.rgy.rgy.dao.ParamsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParamsService {
    @Autowired
    ParamsDao paramsDao;

    public boolean add(Params params){
        if (params.getParamsName() == "" ) {
            return false;
        }
        params.setInfoState( 0 );
        Params params1 = paramsDao.save(params);
        if(params1 != null){
            return true;
        }else{
            return false;
        }
    }

    public boolean update(Params params) {
        if (params.getParamsName() == "" || paramsDao.findByItemsId( params.getItemsId() ) == null) {
            return false;
        }
        params.setInfoState( 0 );
        if (paramsDao.save( params ) != null) {
            return true;
        }
        return false;
    }

    public List<Params> findByParamsName(String roleName, Integer itemsId){
        List<Params> params = paramsDao.findByParamsNameLike( "%" + roleName + "%" );
        for (int i = 0; i < params.size(); i++) {
            if (params.get( i ).getInfoState() == 1 || params.get( i ).getItemsId() != itemsId) {
                params.remove( i );
                i--;
            }
        }
        return params;
    }

    public List<Params> findAll(Integer itemsId){
        List<Params> params = paramsDao.findByItemsId( itemsId );
        for (int i = 0; i < params.size(); i++) {
            if (params.get( i ).getInfoState() == 1 ) {
                params.remove( i );
                i--;
            }
        }
        return params;
    }

    public boolean delete(Integer paramsId) {
        Params params = paramsDao.findByParamsId( paramsId );
        if (params != null) {
            params.setInfoState( 1 );
            if (paramsDao.save( params ) != null) {
                return true;
            }
        }
        return false;
    }

}
