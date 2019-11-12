package com.rgy.rgy.controller;

import com.rgy.rgy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gaoyk
 * @Date: 2019/11/8 11:46
 */

@RestController
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ContractService contractService;
}
