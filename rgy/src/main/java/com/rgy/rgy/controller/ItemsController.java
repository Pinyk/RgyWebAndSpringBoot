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

@CrossOrigin
@RestController
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    ItemsService itemsService;

    /**
     * 新增实验项
      * @param items
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Items items){
        if (itemsService.add(items)) {
            return new Result("success","新增成功");
        } else {
            return new Result( "error", "新增失败" );
        }
    }

    /**
     * 返回所有试验项
     * @return
     */

    @GetMapping("/findall")
    public Result findAll(){
        List<Items> items = itemsService.findAll();
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
    public Result idel(@RequestParam Integer itemsId){
        if(itemsService.del(itemsId)){
            return new Result("success","删除成功");
        }else{
            return new Result("error","删除失败");
        }
    }
}
