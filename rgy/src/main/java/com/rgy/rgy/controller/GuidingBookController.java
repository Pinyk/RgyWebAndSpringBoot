package com.rgy.rgy.controller;

import com.rgy.rgy.bean.GuidingBook;
import com.rgy.rgy.bean.Material;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.GuidingBookService;
import com.rgy.rgy.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author：AnZhuJun
 * @Date: 2019/11/17 16:00
 */


@RestController
@RequestMapping("/guidingbook")
public class GuidingBookController {
    @Autowired
    GuidingBookService guidingBookService;

    //添加
    @PostMapping("/add")
    public Result add(@RequestBody GuidingBook guidingBook){
        guidingBookService.add(guidingBook);
        return new Result("success","操作成功");
    }

    //修改
    @PostMapping("/update")
    public Result update(GuidingBook guidingBook){
        guidingBook.setGuidingBookId(guidingBook.getGuidingBookId());
        guidingBookService.update(guidingBook);
        return new Result("success","操作成功");
    }

    @GetMapping("/findAll")
    public Result findAll(){
        List<GuidingBook> guidingBooks = guidingBookService.findAll();
        if(guidingBooks!=null){
            return new Result("success","返回成功",guidingBooks);
        }else{
            return new Result("error","返回失败");
        }
    }

    @DeleteMapping("/delete")
    public Result gdel(@RequestParam int id){
        if(guidingBookService.gdel(id)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }
}
