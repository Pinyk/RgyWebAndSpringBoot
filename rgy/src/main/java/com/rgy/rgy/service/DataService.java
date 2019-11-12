package com.rgy.rgy.service;

import com.rgy.rgy.dao.DataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 实验数据
 * @Author: gaoyk
 * @Date: 2019/11/4 20:31
 */
@Service
public class DataService {
    @Autowired
    DataDao dataDao;
}
