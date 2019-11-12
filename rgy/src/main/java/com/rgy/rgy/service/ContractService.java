package com.rgy.rgy.service;

import com.rgy.rgy.dao.ContractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: gaoyk
 * @Date: 2019/11/8 11:10
 */
@Service
public class ContractService {
    @Autowired
    ContractDao contractDao;
}
