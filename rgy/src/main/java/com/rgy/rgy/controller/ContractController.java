package com.rgy.rgy.controller;

import com.rgy.rgy.bean.Contract;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: AnZhuJun
 * @Date: 2019/11/15 14:46
 */

@RestController
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ContractService contractService;

    /**
     * 新增合同
     * @return
     */
    @GetMapping("/add")
    public Result add(@RequestBody Contract contract) {
        if (contractService.add( contract )) {
            return new Result( "success", "添加成功" );
        } else {
            return new Result( "error", "添加失败" );
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Contract contract){
        if (contractService.update( contract )) {
            return new Result("success","更新成功");
        } else {
            return new Result("error","更新失败");
        }
    }

    /**
     * 返回所有合同
     * @return
     */
    @GetMapping("/findAll")
    public Result findAll(){
        List<Contract> contracts = contractService.findAll();
        if(contracts != null && !contracts.isEmpty()){
            return new Result("success","返回成功",contracts);
        }else{
            return new Result("error","返回失败");
        }
    }
    /**
     * 删除合同
     * @param contractId
     * @return
     */
    @GetMapping("/delete")
    public Result delete(@RequestParam int contractId){
        if(contractService.delete(contractId)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }

    /**
     * 通过合同名查找合同

    @GetMapping("/findbyName")
    public Result find(@RequestParam String contractName){
        List<Contract> contract = contractService.findContractByContractName(contractName);
        if(contract!=null && !contract.isEmpty()){
            return new Result("success","查找成功",contract);
        }else{
            return new Result("error","查找失败");
        }
    }
    */

    /**
     * 通过综合条件查找合同
     */
    @GetMapping("/findcondition")
    public Result findByCondition(@RequestParam(required = false) String contractName,
                                  @RequestParam(required = false) Integer infoState,
                                  @RequestParam(required = false) String businessType,
                                  @RequestParam(required = false) String partyA,
                                  @RequestParam(required = false) String partyB,
                                  @RequestParam(required = false) String projectManager,
                                  @RequestParam(required = false) String salesMan,
                                  @RequestParam(required = false) String signDate,
                                  @RequestParam(required = false) String executiveStartDate,
                                  @RequestParam(required = false) String executiveEndDate){

        List<Contract> contracts = contractService.findByCondition( contractName, infoState, businessType,
                partyA, partyB, projectManager, salesMan, signDate,executiveStartDate,
                executiveEndDate );

        if(contracts != null && !contracts.isEmpty()){
            return new Result("success","返回成功",contracts);
        }else{
            return new Result("error","返回失败");
        }
    }
}
