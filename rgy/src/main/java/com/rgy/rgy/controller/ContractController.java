package com.rgy.rgy.controller;

import com.rgy.rgy.bean.Contract;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: AnZhuJun
 * @Date: 2019/11/15 14:46
 */

@CrossOrigin
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
        if(contracts != null && !contracts.isEmpty() ){
            return new Result("success","返回成功",contracts);
        }else{
            return new Result("error","返回失败");
        }
    }

//    /**
//     * 根据id判断是否有数据
//     */
//    @PostMapping("/isidexist")
//    public Boolean isIdExist(@RequestParam Integer contractId) {
//        return contractService.isidExist(contractId);
//    }

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
     * 删除合同
     * @param contractId
     * @return
     */
    @GetMapping("/delete")
    public Result delete(@RequestParam Integer contractId){
        if(contractService.delete(contractId)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }

    /**
     * 通过合同名查找合同*/

//    @GetMapping("/findbyName")
//    public Result find(@RequestParam String contractName){
//        List<Contract> contract = contractService.findContractByContractName(contractName);
//        if(contract!=null && !contract.isEmpty()){
//            return new Result("success","查找成功",contract);
//        }else{
//            return new Result("error","查找失败");
//        }
//    }

    /*
    根据合同名称模糊查询
     */
    @GetMapping("/findbyName")
    public Result find(@RequestParam String contractName){
        List<Contract> contract = contractService.findByName(contractName);
       if(contract!=null && !contract.isEmpty()){
            return new Result("success","查找成功",contract);
       }else{
            return new Result("error","查找失败");
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



    private String changeFileName(String filename)
    {
        return null;
    }
    //单文件上传
    @PostMapping("/fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);
        String path = "F:\\热工院项目\\rgy-master\\rgy-master\\src\\main\\resources\\contractfiles" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return "true";
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        }
    }

    //多文件上传
//    @RequestMapping(value="multifileUpload",method= RequestMethod.POST)
    @PostMapping("/multifileload")
    public @ResponseBody Result multifileUpload(HttpServletRequest request){

        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");

        if(files.isEmpty()){
            return new Result("error","失败1");
        }

        String path = "F:\\热工院项目\\rgy-master\\rgy-master\\src\\main\\resources\\contractfiles" ;

        for(MultipartFile file:files){
            String fileName = file.getOriginalFilename();
            int size = (int) file.getSize();
            System.out.println(fileName + "-->" + size);

            if(file.isEmpty()){
                return new Result("error","失败2");
            }else{
                File dest = new File(path + "/" + fileName);
                if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest);
                }catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return new Result("error","失败3");
                }
            }
        }
        return new Result("success","成功");
    }
}
