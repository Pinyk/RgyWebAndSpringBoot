package com.rgy.rgy.controller;


import com.rgy.rgy.bean.Result;
import com.rgy.rgy.bean.Role;
import com.rgy.rgy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Silvia
 * @Date: 2019/11/6  22:49
 */

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    /**
     * 根据名称查询角色
     * @param name
     * @return
     */
    @GetMapping("/getByName")
    public Result getByName ( String name ){
        Role role = roleService.findByName( name );
        if (role != null) {
            return new Result( "success","查询成功", role );
        } else {
            return new Result( "error","查询失败" );
        }

    }
    /**
     * 查询所有角色
     * @return
     */
    @GetMapping("/getAll")
    public Result getAll() {
        List<Role> roles = roleService.findAll();
        if (roles != null) {
            return new Result( "success","查询成功", roles );
        }else {
            return new Result( "error","查询失败" );
        }
    }

    /**
     * 修改角色信息
     * @param role
     * @return
     */
    @GetMapping("/updateRole")
    public Result updateRole( Role role ) {
        roleService.update( role );
        return new Result( "success", "修改成功");
    }

    /**
     * 保存新增角色
     * @param role
     * @return
     */
    @GetMapping("/saveRole")
    public Result saveRole( Role role ) {
        roleService.update( role );
        return new Result( "success", "保存成功");
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @GetMapping("/deleteRole")
    public Result deleteRole( int id ) {
        if (roleService.delete( id )) {
            return new Result( "success", "删除成功" );
        } else {
            return new Result( "error", "删除失败" );
        }
    }

}
