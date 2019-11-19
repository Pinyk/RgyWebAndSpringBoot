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
    @PostMapping("/add")
    public Result cadd(@RequestParam String contractNumber,
                       @RequestParam String contractName,
                       @RequestParam double contractAmount,
                       @RequestParam String currency,
                       @RequestParam String salesMan,
                       @RequestParam String signYear,
                       @RequestParam String signDate,
                       @RequestParam String contractArea,
                       @RequestParam String businessType,
                       @RequestParam String overview,
                       @RequestParam String contractText,
                       @RequestParam String abnormalNote,
                       @RequestParam String partyA,
                       @RequestParam String partyAAddress,
                       @RequestParam String partyALinkman,
                       @RequestParam String partyAPhone,
                       @RequestParam String partyAEmail,
                       @RequestParam String partyB,
                       @RequestParam String partyBLinkman,
                       @RequestParam String partyBPhone,
                       @RequestParam String partyBEmail,
                       @RequestParam String executiveDept,
                       @RequestParam String executiveStartDate,
                       @RequestParam String executiveEndDate,
                       @RequestParam String projectManager,
                       @RequestParam String projectExecutive,
                       @RequestParam String reportNumber,
                       @RequestParam String reportUrl,
                       @RequestParam String reportMailingDate,
                       @RequestParam double lnvoiceAmount,
                       @RequestParam String lnvoiceDate,
                       @RequestParam String receiptDate,
                       @RequestParam String mailingDate,
                       @RequestParam String detailsNote,
                       @RequestParam String receiverAddress,
                       @RequestParam String receiverName,
                       @RequestParam String receiverPhone,
                       @RequestParam double paymentAmount,
                       @RequestParam String paymentDate,
                       @RequestParam double paybackBalance,
                       @RequestParam String paymentNote){
        int contractsId = contractService.cadd(contractNumber, contractName, contractAmount, currency, salesMan, signYear, signDate, contractArea, businessType, overview, contractText, abnormalNote, partyA, partyAAddress, partyALinkman, partyAPhone, partyAEmail, partyB, partyBLinkman, partyBPhone, partyBEmail, executiveDept, executiveStartDate, executiveEndDate, projectManager, projectExecutive, reportNumber, reportUrl, reportMailingDate, lnvoiceAmount, lnvoiceDate, receiptDate, mailingDate, detailsNote, receiverAddress, receiverName, receiverPhone, paymentAmount, paymentDate, paybackBalance, paymentNote);
        return new Result("success","新增成功",contractsId);
    }

    @PostMapping("/update")
    public void update(Contract contract){
        contract.setContractId(contract.getContractId());
        contractService.update(contract);
    }

    /**
     * 返回所有合同
     * @return
     */
    @GetMapping("/creturn")
    public Result creturnAll(){
        List<Contract> contracts = contractService.findAll();
        if(contracts!=null){
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
    public Result cdel(@RequestBody int contractId){
        if(contractService.cdel(contractId)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }

    /**
     * 通过合同名查找合同
     */
    @GetMapping("/findbyName")
    public Result find(@RequestParam String contractName){
        List<Contract> contract = contractService.findContractByContractName(contractName);
        if(contract!=null){
            return new Result("success","查找成功",contract);
        }else{
            return new Result("error","查找失败");
        }
    }

    /**
     * 通过综合条件查找合同
     */
    @GetMapping("/findcondition")
    public Result findByCondition(@RequestParam String contractName,
                                  @RequestParam String partyA,
                                  @RequestParam String partyB,
                                  @RequestParam String SalesMan,
                                  @RequestParam String ProjectManager,
                                  @RequestParam String SignDate,
                                  @RequestParam String ExecutiveStartDate,
                                  @RequestParam String ExecutiveEndDate){
        Contract contract =
                contractService.findContractByContractNameAndPartyAAndPartyBAndSalesManAndProjectManagerAndSignDateAndExecutiveStartDateAndExecutiveEndDate(
                contractName,
                partyA,
                partyB,
                SalesMan,
                ProjectManager,
                SignDate,
                ExecutiveStartDate,
                ExecutiveEndDate);
        if(contract != null){
            return new Result("success","返回成功",contract);
        }else{
            return new Result("error","返回失败");
        }
    }
}
