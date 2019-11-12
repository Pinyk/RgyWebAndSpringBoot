package com.rgy.rgy.controller;
import com.rgy.rgy.bean.CaseLibrary;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.CaseLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author：xiongxy
 * @Date: 2019/10/28 22:00
 */

@RestController
@RequestMapping("/caseLibrary")
public class CaseLibraryController {
    @Autowired
    CaseLibraryService caseLibraryService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/findAll")
    public List<CaseLibrary> findAll(){
        return caseLibraryService.findAll();
    }

    /**
     * 模糊查询
     * @param keyword
     * @return
     */
    @RequestMapping("/findByKeywordLike/{keyword}")
    public List<CaseLibrary> findByKeywordLike(@PathVariable (name = "keyword") String keyword){
        return caseLibraryService.findByKeywordLike(keyword);
    }

    /**
     * 新增
     * @param caseLibrary
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody CaseLibrary caseLibrary){
        if ( caseLibraryService.add(caseLibrary)){
            return new Result("success","添加成功");
        }
        else
            return new Result("error","添加失败");

    }

    /**
     * 更新
     * @param caseLibrary
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody CaseLibrary caseLibrary){
        if ( caseLibraryService.update(caseLibrary)){
            return new Result("success","更新成功");
        }
        else
            return new Result("error","更新失败");

    }


    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable(name = "id") int id){
        if (caseLibraryService.delete(id)){
            return new Result("success","删除成功");
        }
        else
            return new Result("error","删除失败");
    }

}
