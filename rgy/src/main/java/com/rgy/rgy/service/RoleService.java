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

    public Role findByName(String name) {
        return roleDao.findByRoleName( name );
    }

    public List<Role> findAll() {
        return roleDao.findAll();
    }

    public boolean update(Role role) {
        Role role1 = roleDao.findByRoleId( role.getRoleId() );
        if (role1 == null) {
            return false;
        }
        role1 = role;
        if (roleDao.save( role1 ) != null) {
            return true;
        }
        return false;
    }

    public boolean add(Role role) {
        role.setInfoState( 0 );
        Role role1 = roleDao.save( role );
        if (role1 != null) {
            return true;
        }
        return false;
    }

    public boolean delete(Integer roleId) {
        Role role = roleDao.findByRoleId( roleId );
        if (role != null) {
            role.setInfoState( 1 );
            roleDao.save( role );
            return true;
        } else {
            return false;
        }
    }
}
