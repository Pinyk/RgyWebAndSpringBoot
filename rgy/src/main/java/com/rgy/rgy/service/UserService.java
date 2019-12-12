package com.rgy.rgy.service;

import com.rgy.rgy.bean.Role;
import com.rgy.rgy.bean.User;
import com.rgy.rgy.dao.RoleDao;
import com.rgy.rgy.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 用户服务
 * @Author: Silvia
 * @Date: 2019/11/6  22:49
 */

@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;

    public List<User> findByNameLike(String userName) {
        List<User> users = userDao.findByUsernameLike( "%" + userName + "%" );
        for (User user : users) {
            if (user.getInfoState() == 1) {
                users.remove( user );
            } else {
                Role role = roleDao.findByRoleId( (Integer.valueOf( user.getRoleId() )) );
                if (role != null && role.getRoleName() != null) {
                    user.setRoleId( role.getRoleName() );
                }
            }

        }
        return users;
    }

    public List<User> findAll() {
        List<User> all = userDao.findAll();
        for (User user :all) {
            if (user.getInfoState() == 1) {
                all.remove( user );
            } else {
                Role role = roleDao.findByRoleId( (Integer.valueOf( user.getRoleId() )) );
                if (role != null && role.getRoleName() != null)
                    user.setRoleId( role.getRoleName() );
            }
        }
        return all;
    }

    public boolean update(User user) {
        User user1 = userDao.findByUserId( user.getUserId() );
        if (user1 == null) {
            return false;
        }
        user1 = user;
        user1.setInfoState( 0 );
        Role role = roleDao.findByRoleName( user1.getRoleId() );
        if (role != null && role.getRoleName() != null) {
            user1.setRoleId( role.getRoleName() );
        }

        if (userDao.save( user1 ) != null) {
            return true;
        }
        return false;
    }

    public boolean add(User user) {
        user.setInfoState( 0 );
        User user1 = userDao.save( user );

        if (user1 != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Integer id) {

        User user = userDao.findByUserId( id );
        if (user != null) {
            user.setInfoState( 1 );
            userDao.save( user );
            return true;
        } else {
            return false;
        }
    }
}
