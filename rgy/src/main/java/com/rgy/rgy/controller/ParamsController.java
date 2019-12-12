package com.rgy.rgy.controller;

import com.rgy.rgy.bean.Params;
import com.rgy.rgy.bean.Result;
import com.rgy.rgy.service.ParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/params")
public class ParamsController {
    @Autowired
    ParamsService paramsService;

    /**
     * 新增参数
     * @param params
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Params params){
        if(paramsService.add(params)){
            return new Result("success","添加成功");
        }else{
            return new Result("error","添加失败");
        }
    }

    @GetMapping("/findByName")
    public Result getByName (@RequestParam String paramsName, @RequestParam Integer itemsId){
        List<Params> byParamsName = paramsService.findByParamsName( paramsName, itemsId );
        if (byParamsName != null && !byParamsName.isEmpty()) {
            return new Result( "success","查询成功", byParamsName );
        } else {
            return new Result( "error","查询失败" );
        }
    }

    @GetMapping("/findall")
    public Result findAll(@RequestParam Integer itemsId) {
        List<Params> params = paramsService.findAll(itemsId);
        if (params != null && !params.isEmpty()) {
            return new Result( "success","查询成功", params );
        }else {
            return new Result( "error","查询失败" );
        }
    }

    @PostMapping("/update")
    public Result updateRole(@RequestBody Params params ) {
        if (paramsService.update( params )) {
            return new Result( "success", "修改成功");
        } else {
            return new Result( "error", "修改失败");
        }
    }
    @GetMapping("/delete")
    public Result deleteRole(@RequestParam Integer paramsId ) {
        if (paramsService.delete( paramsId )) {
            return new Result( "success", "删除成功" );
        } else {
            return new Result( "error", "删除失败" );
        }
    }

}
