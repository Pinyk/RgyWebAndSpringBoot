package com.rgy.rgy.service;

import com.rgy.rgy.dao.EquipmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: gaoyk
 * @Date: 2019/11/1 23:22
 */

@Service
public class EquipmentService{
    @Autowired
    EquipmentDao equipmentDao;
}
