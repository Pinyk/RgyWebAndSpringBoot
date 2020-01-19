package com.rgy.rgy;


import com.rgy.rgy.bean.Contract;
import com.rgy.rgy.bean.beanToAndroid.ContractComment;
import com.rgy.rgy.dao.ContractDao;
import com.rgy.rgy.dao.ProjectDao;
import com.rgy.rgy.dao.daoToAndroid.ContractCommentDao;
import com.rgy.rgy.service.ContractService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SprintBootTests {

    @Autowired
    private ContractCommentDao contractCommentDao;

    @Autowired
    private ContractDao contractDao;
    @Autowired
    private ProjectDao projectDao;



    @Test
    public void test()
    {
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String date=sDateFormat.format(new Date());
        ContractComment contractComment=new ContractComment();
        contractComment.setUserId(1);
        contractComment.setCommentContent("1111");
        contractComment.setCommentTime(date);
        contractComment.setContractId(7);
        contractCommentDao.save(contractComment);
        System.out.println("11111");
    }

    @Test
    public void test2()
    {
        List<ContractComment> res = contractCommentDao.getContractCommentsByContractId(7);
        for(ContractComment e:res){
            System.out.println(e.getCommentContent());
        }
    }

    @Test
    public void test3()
    {
        List<Contract> res = contractDao.findByName("1");
        for(Contract e:res){
            System.out.println(e.getContractName()+"!!!!!!!");
        }
    }

    public static void main(String[] args) {
        System.out.println(SprintBootTests.class.getResource(""));
    }
}
