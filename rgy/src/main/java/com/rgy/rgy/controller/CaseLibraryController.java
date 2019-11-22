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

@CrossOrigin
@RestController
@RequestMapping("/caseLibrary")
public class CaseLibraryController {
    @Autowired
    CaseLibraryService caseLibraryService;

    /**
     * 查询所有案例信息
     * @return
     */
    @GetMapping("/findall")
    public Result findAll(){
        List<CaseLibrary> caseLibraries = caseLibraryService.findAll();
        if (caseLibraries != null && !caseLibraries.isEmpty()){
            return new Result("success","返回成功",caseLibraries);
        }else{
            return new Result("error","返回失败");
        }
    }

    /**
     * 模糊查询
     * @param keyword
     * @return
     */
    @GetMapping("/findByKeywordLike")
    public Result findByKeywordLike(@RequestParam(required = false) String keyword){
         List<CaseLibrary> caseLibraries =caseLibraryService.findByKeywordLike(keyword);
         if (caseLibraries != null && !caseLibraries.isEmpty()){
             return new Result("success","返回成功",caseLibraries);
         }else{
             return new Result("error","返回失败");
         }
    }

    /**
     * 新增案例信息
     * @param caseLibrary
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody CaseLibrary caseLibrary){
        if ( caseLibraryService.add(caseLibrary)){
            return new Result("success","添加成功");
        }
        else
            return new Result("error","添加失败");

    }

    /**
     * 更新案例信息
     * @param caseLibrary
     * @return
     */
    @GetMapping("/update")
    public Result update(@RequestBody CaseLibrary caseLibrary){
        if ( caseLibraryService.update(caseLibrary)){
            return new Result("success","更新成功");
        }
        else
            return new Result("error","更新失败");

    }


    /**
     * 根据id删除
     * @param caseLibraryID
     * @return
     */
    @GetMapping("/delete")
    public Result delete(@RequestParam Integer caseLibraryID){
        if (caseLibraryService.delete(caseLibraryID)){
            return new Result("success","删除成功");
        }
        else
            return new Result("error","删除失败");
    }

}
