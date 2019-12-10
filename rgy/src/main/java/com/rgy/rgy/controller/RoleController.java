package com.rgy.rgy.controller;

import com.rgy.rgy.bean.Result;
import com.rgy.rgy.bean.Role;
import com.rgy.rgy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: Silvia
 * @Date: 2019/11/6  22:49
 */

@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    /**
     * 根据名称查询角色
     * @param roleName
     * @return
     */
    @GetMapping("/findByName")
    public Result getByName (@RequestParam String roleName ){
        List<Role> roles = roleService.findByRoleName( roleName );
        if (roles != null && !roles.isEmpty()) {
            return new Result( "success","查询成功", roles );
        } else {
            return new Result( "error","查询失败" );
        }
    }

    /**
     * 查询所有角色
     * @return
     */
    @GetMapping("/findall")
    public Result findAll() {
        List<Role> roles = roleService.findAll();
        if (roles != null && !roles.isEmpty()) {
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
    @PostMapping("/update")
    public Result updateRole(@RequestBody Role role ) {
        if (roleService.update( role )) {
            return new Result( "success", "修改成功");
        } else {
            return new Result( "error", "修改失败");
        }

    }

    /**
     * 保存新增角色
     * @param role
     * @return
     */
    @PostMapping("/add")
    public Result saveRole(@RequestBody Role role ) {
        if ( roleService.add( role ) ) {
            return new Result( "success", "新增成功");
        } else {
            return new Result( "error", "新增失败");
        }
    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @GetMapping("/delete")
    public Result deleteRole(@RequestParam Integer roleId ) {
        if (roleService.delete( roleId )) {
            return new Result( "success", "删除成功" );
        } else {
            return new Result( "error", "删除失败" );
        }
    }
}
