package com.rgy.rgy.service;

import com.rgy.rgy.bean.User;
import com.rgy.rgy.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务
 * @Author: Silvia
 * @Date: 2019/11/6  22:49
 */

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    /**
     * 用户登录
     * @param name
     * @param password
     * @return
     */
    public boolean login(String name, String password) {

        User user = userDao.findByUserName( name );
        if (user.getUserName() == null) {
            return false;
        }

        String userName = user.getUserName();
        String userPassword = user.getPassword();

        if (name.equals(userName) && password.equals(userPassword)) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 根据姓名查询用户
     * @param name
     * @return
     */
    public User findByName(String name){
        return userDao.findByUserName( name );
    }

    /**
     * 修改用户信息
     * @param user
     */
    public void update(User user) {
        userDao.save( user );
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll(){
        return userDao.findAll();
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    public boolean delete(int id) {
        User current = userDao.findById( id ).orElse( new User(-1,"null","null","null","null",-1, 0) );

        if (current.getUserId() > -1) {
            current.setInfoState( 1 );
            userDao.save( current );
            return true;
        } else {
            return false;
        }
    }

}
