package com.rgy.rgy.controller.controllerToAndroid;

import com.rgy.rgy.bean.Contract;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/contractToAndroid")
public class ContractControllerToA {

    @Autowired
    ContractService contractService;

    /**
     * 返回所有合同
     * @return
     */
    @GetMapping("/findall")
    public Result findAll(){
        List<Contract> contracts = contractService.findAll();
        if(contracts != null && !contracts.isEmpty() ){
            return new Result("success","返回成功",contracts);
        }else{
            return new Result("error","返回失败");
        }
    }

    /**
     * 修改合同状态
     * @param infoState
     * @param contractId
     * @return
     */
    @GetMapping("/updateState")
    public Result update(@RequestParam("infoState")Integer infoState,
                         @RequestParam("contractId")Integer contractId){

        Contract contract = contractService.findbyid(contractId);
        contract.setInfoState(infoState);
        boolean res = contractService.update(contract);
        if(res){
            return new Result("success","返回成功",contract);
        }else{
            return new Result("error","返回失败");
        }
    }

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

    /**
     * 根据id传数据
     */
    @GetMapping("/findbyid")
    public Result findById(@RequestParam Integer contractId) {
        Contract contract = contractService.findbyid(contractId);
        if (contract != null) {
            return new Result("success","返回成功",contract);
        }else {
            return new Result("error","返回失败");
        }
    }

    /**
     * 预览合同
     * @param res
     * @param fileName
     */
    @GetMapping(value = "/contractDownload")
    public void downLoad(HttpServletResponse res,@RequestParam(required = false) String fileName){

        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File("F:\\热工院项目\\rgy-master\\rgy-master\\src\\main\\resources\\contractfiles"
                    + fileName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
