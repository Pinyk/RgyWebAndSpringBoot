package com.rgy.rgy.service;
import com.rgy.rgy.bean.Params;
import com.rgy.rgy.dao.ParamsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: gaoyk
 * @Date: 2019/11/5 22:40
 */

@Service
public class ParamsService {
    @Autowired
    ParamsDao paramsDao;

    public boolean padd(Params params){
        Params params1 = paramsDao.save(params);
        if(params1!=null){
            return true;
        }else{
            return false;
        }
    }
}
