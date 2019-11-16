package com.rgy.rgy.controller;

import com.rgy.rgy.bean.Result;
import com.rgy.rgy.bean.User;
import com.rgy.rgy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
     * 用户登录
     * @param name
     * @param password
     * @return
     */
    @GetMapping("/login")
    public Result Login (String name, String password) {
            boolean verify;
            verify = userService.login(name, password);

            if (verify == true) {
                return new Result("success", "登陆成功");
            }else {
                return new Result( "error", "登录失败" );
            }

    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/getAll")
    public Result getAll(){
        List<User> users = userService.findAll();
        if(users != null){
            return new Result( "success","查询成功", users );
        }else {
            return new Result( "error","查询失败" );
        }
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @GetMapping("/saveUser")
    public Result saveUser( User user ) {
        userService.update( user );
        return new Result( "success", "保存成功");
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @GetMapping("/updateUser")
    public Result updateUser( User user ) {
        userService.update( user );
        return new Result( "success", "修改成功");
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("/deleteUser")
    public Result deleteUser( int id ) {
        if (userService.delete( id )) {
            return new Result( "success", "删除成功"  );
        } else {
            return new Result( "error", "删除失败" );
        }
    }

}
