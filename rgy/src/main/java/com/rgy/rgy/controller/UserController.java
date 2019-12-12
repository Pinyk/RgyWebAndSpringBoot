package com.rgy.rgy.controller;

import com.rgy.rgy.bean.Result;
import com.rgy.rgy.bean.User;
import com.rgy.rgy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Silvia
 * @Date: 2019/11/6  22:49
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    /**
     * 查询所有
     * @return
     */

    @GetMapping("/findall")
    public Result getAll(){
        List<User> all = userService.findAll();
        if(!all.isEmpty() && all != null){
            return new Result( "success","查询成功", all );
        }else {
            return new Result( "error","查询失败" );
        }
    }

    /**
     * 根据名称查询
     */
    @GetMapping("/findByName")
    public Result findByName(@RequestParam String name) {
        List<User> byNameLike = userService.findByNameLike( name );
        if(byNameLike!=null) {
            return new Result( "success","查询成功", byNameLike );
        } else {
            return new Result( "error","查询失败" );
        }
    }


    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/add")
    public Result saveUser( @RequestBody User user ) {
        if(userService.add( user )) {
            return new Result( "success", "保存成功");
        } else {
            return new Result("error","添加失败");
        }
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Result updateUser( @RequestBody User user ) {
        if (userService.update( user )) {
            return new Result( "success", "更新成功");
        } else{
            return new Result("error","更新失败");
        }
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @GetMapping("/delete")
    public Result deleteUser(@RequestParam Integer userId ) {
        if (userService.delete( userId )) {
            return new Result( "success", "删除成功"  );
        } else {
            return new Result( "error", "删除失败" );
        }
    }

}
