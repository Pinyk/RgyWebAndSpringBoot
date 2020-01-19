package com.rgy.rgy.controller.controllerToAndroid;

import com.rgy.rgy.bean.Result;
import com.rgy.rgy.bean.beanToAndroid.ContractComment;
import com.rgy.rgy.service.ContractService;
import com.rgy.rgy.service.serviceToAndroid.ContractCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/contractCommentToAndroid")
public class ContractCommentControllerToA {

    @Autowired
    private ContractCommentService contractCommentService;

    //添加评论
    @PostMapping("/add")
    public Result add(@RequestBody ContractComment contractComment) {
        if (contractCommentService.add(contractComment)) {
            return new Result( "success", "添加成功" );
        } else {
            return new Result( "error", "添加失败" );
        }
    }
    //根据合同编号查询历史评论
    @GetMapping("/findByContractId")
    public Result findAll(@RequestParam  Integer contractId){
        List<ContractComment> contractComments = contractCommentService.getContractCommentsByContractId(contractId);
        if(contractComments != null && !contractComments.isEmpty() ){
            return new Result("success","返回成功",contractComments);
        }else{
            return new Result("error","返回失败");
        }
    }
}
