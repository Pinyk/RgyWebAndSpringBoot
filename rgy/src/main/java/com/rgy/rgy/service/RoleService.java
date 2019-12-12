package com.rgy.rgy.service;

import com.rgy.rgy.bean.Role;
import com.rgy.rgy.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeSet;


/**
 * 角色服务
 * @Author: Silvia
 * @Date: 2019/11/6  22:49
 */

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;

    public List<Role> findByRoleName(String roleName){
        List<Role> roles = roleDao.findByRoleNameLike( "%" + roleName + "%" );
        for (Role role: roles) {
            if (role.getInfoState() == 1) {
                roles.remove( role );
            } else {
                role.setAuthorities( getAuthorities(role) );
            }
        }
        return roles;
    }

    public List<Role> findAll() {
        List<Role> roles = roleDao.findAll();

        for (int i = 0; i < roles.size(); i++) {
            if (roles.get( i ).getInfoState() == 1) {
                roles.remove( roles.get( i ) );
            } else {
                roles.get(i).setAuthorities( getAuthorities( roles.get( i ) ) );
            }
        }

        return roles;
    }

    public String getAuthorities(Role role) {
        TreeSet<String> all = new TreeSet<String>();
        String[] authorities = role.getAuthorities().split( "," );
        for (String a : authorities) {
            if (a.equals( "1" )) {
                all.add( "电厂管理" );
            } else if (a.equals( "2" )) {
                all.add( "设备类型管理" );
            } else if (a.equals( "3" )) {
                all.add( "设备管理" );
            } else if (a.equals( "4" )) {
                all.add( "合同管理" );
            } else if (a.equals( "5" )) {
                all.add( "试验报价管理" );
            } else if (a.equals( "6" )) {
                all.add( "实验报告模板管理" );
            } else if (a.equals( "7" )) {
                all.add( "试验报告管理" );
            } else if (a.equals( "8" )) {
                all.add( "作业指导书管理" );
            } else if (a.equals( "9" )) {
                all.add( "用户管理" );
            } else if (a.equals( "10" )) {
                all.add( "角色管理" );
            } else if (a.equals( "11" )) {
                all.add( "合同（APP）" );
            } else if (a.equals( "12" )) {
                all.add( "设备（APP）" );
            } else if (a.equals( "13" )) {
                all.add( "指导书（APP）" );
            } else if (a.equals( "14" )) {
                all.add( "报价（APP）" );
            }
        }
        String auth = new String();
        for (String a : all) {
            auth = auth + a + ",";
        }
        auth = auth.substring( 0, auth.length() - 1 );
        return auth;
    }


    public boolean update(Role role) {
        if (role.getRoleName() == "") {
            return false;
        }
        Role role1 = roleDao.findByRoleId( role.getRoleId() );
        if (role1 == null) {
            return false;
        }
        if (role.getAuthorities() == null && role.getAuthorities() == "") {
            role.setAuthorities( "0" );
        }
        role1 = role;
        role1.setInfoState( 0 );
        if (roleDao.save( role1 ) != null) {
            return true;
        }
        return false;
    }

    public boolean add(Role role) {
        if (role.getRoleName() == "") {
            return false;
        }
        role.setInfoState( 0 );
        if (role.getAuthorities() == "") {
            role.setAuthorities( "0" );
        }
        Role role1 = roleDao.save( role );
        if (role1 != null) {
            return true;
        } else {
            return false;
        }
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
