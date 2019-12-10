package com.rgy.rgy.dao;

import com.rgy.rgy.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色Dao层
 * @Author: Silvia
 * @Date: 2019/11/6  22:49
 */

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
    List<Role> findByRoleNameLike(String roleName);
    Role findByRoleName(String roleName);
    Role findByRoleId(Integer Id);
}
