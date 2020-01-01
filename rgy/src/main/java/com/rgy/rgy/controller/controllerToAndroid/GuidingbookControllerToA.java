package com.rgy.rgy.controller.controllerToAndroid;


import com.rgy.rgy.bean.GuidingBook;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.GuidingBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/guidingbookToAndroid")
public class GuidingbookControllerToA {

    @Autowired
    GuidingBookService guidingBookService;

    /**
     * 返回所有作业指导书的信息
     * @return
     */
    @GetMapping("/findall")
    public Result findAll(){
        List<GuidingBook> guidingBooks = guidingBookService.findAll();
        if(guidingBooks!=null && !guidingBooks.isEmpty()){
            return new Result("success","返回成功",guidingBooks);
        }else{
            return new Result("error","返回失败");
        }
    }

    /**
     * 模糊查询
     * @param guidingBookName
     * @return
     */
    @GetMapping("/findByName")
    public Result find(@RequestParam(required = false) String guidingBookName){
        List<GuidingBook> guidingBooks = guidingBookService.findByKeywordLike(guidingBookName);
        if (guidingBooks != null && !guidingBooks.isEmpty()){
            return new Result("success","返回成功",guidingBooks);
        }else{
            return new Result("error","返回失败");
        }
    }
}
