package com.rgy.rgy.service;

import com.rgy.rgy.bean.Role;
import com.rgy.rgy.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 角色服务
 * @Author: Silvia
 * @Date: 2019/11/6  22:49
 */

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;

    /**
     * 根据名称查询角色
     * @param name
     * @return
     */
    public Role findByName(String name) {
        return roleDao.findByRoleName( name );
    }

    /**
     * 查询所有角色
     * @return
     */
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    /**
     * 修改角色信息
     * @param role
     */
    public void update(Role role) {
        roleDao.save( role );
    }

    /**
     * 保存角色信息
     * @param role
     */
    public void save(Role role) {
        roleDao.save( role );
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    public boolean delete(int id) {
        Role current = roleDao.findById( id ).orElse( new Role( -1,"null", "null", 0) );
        if (current.getRoleId() > -1) {
            current.setInfoState( 1 );
            return true;
        } else {
            return false;
        }
    }

}
