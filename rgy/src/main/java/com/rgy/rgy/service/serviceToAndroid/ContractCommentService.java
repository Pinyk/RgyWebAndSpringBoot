package com.rgy.rgy.service.serviceToAndroid;


import com.rgy.rgy.bean.beanToAndroid.ContractComment;
import com.rgy.rgy.dao.daoToAndroid.ContractCommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ContractCommentService {

    @Autowired
    private ContractCommentDao contractCommentDao;

    //添加评论
    public boolean add(ContractComment contractComment)
    {
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String commentTime=sDateFormat.format(new Date());
        contractComment.setCommentTime(commentTime);
        ContractComment contractComment1 = contractCommentDao.save(contractComment);
        if(contractComment1!=null)
        {
            return true;
        }else{
            return false;
        }
    }
    //根据合同编号查询历史评论
    public List<ContractComment> getContractCommentsByContractId(Integer contractId)
    {
        return contractCommentDao.getContractCommentsByContractId(contractId);
    }
}
