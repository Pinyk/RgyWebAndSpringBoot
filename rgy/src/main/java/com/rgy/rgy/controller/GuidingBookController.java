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

    /**
     * 添加作业指导书信息
     * @param guidingBook
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody GuidingBook guidingBook){
        if(guidingBookService.add(guidingBook)) {
            return new Result("success", "操作成功");
        }else{
            return new Result("error","操作失败");
        }
    }

    /**
     * 更新作业指导书信息
     * @param guidingBook
     * @return
     */
    @GetMapping("/update")
    public Result update(@RequestBody GuidingBook guidingBook){
        if (guidingBookService.update(guidingBook)){
            return new Result("success","操作成功");
        }else{
            return new Result("error","操作失败");
        }
    }

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
     * 根据id进行删除
     * @param guidingBookId
     * @return
     */
    @GetMapping("/delete")
    public Result gdel(@RequestParam Integer guidingBookId){
        if(guidingBookService.delete(guidingBookId)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }
}
