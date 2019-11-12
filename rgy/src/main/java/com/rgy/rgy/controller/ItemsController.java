package com.rgy.rgy.controller;

import com.rgy.rgy.bean.Items;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author：gaoyk
 * @Date: 2019/10/31 22:02
 */

@RestController
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    ItemsService itemsService;

    /**
     * 新增/修改试验项
     * templateId为上一步(/templates/add)返回参数
     * @param itemsName
     * @param sort
     * @param templateId
     * @return
     */
    @PostMapping("/add")
    public Result iadd(@RequestParam String itemsName,@RequestParam String sort, int templateId){
        int itemsId = itemsService.iadd(itemsName,sort,templateId);
        return new Result("success","新增成功", itemsId);
    }

    /**
     * 返回所有试验项
     * @return
     */
    @GetMapping("/ireturn")
    public Result ireturnAll(){
        List<Items> items = itemsService.ireturnAll();
        if(items!=null){
            return new Result("success","返回成功",items);
        }else{
            return new Result("error","返回失败");
        }
    }

    /**
     * 删除试验项
     * @param itemsId
     * @return
     */
    @GetMapping("delete")
    public Result idel(@RequestParam int itemsId){
        if(itemsService.idel(itemsId)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }
}
