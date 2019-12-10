package com.rgy.rgy.dao;

import com.rgy.rgy.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户Dao层
 * @Author: Silvia
 * @Date: 2019/11/6  22:49
 */

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    User findByUserId(Integer id);
    List<User> findByUsernameLike(String userName);
    User findByUsername(String userName);
}
