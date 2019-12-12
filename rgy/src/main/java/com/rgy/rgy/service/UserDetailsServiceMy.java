package com.rgy.rgy.service;


import com.rgy.rgy.bean.Role;
import com.rgy.rgy.bean.User;
import com.rgy.rgy.dao.RoleDao;
import com.rgy.rgy.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: Silvia
 * @Date: 2019/11/9  16:55
 */

@Service
public class UserDetailsServiceMy implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userDao.findByUsername( username );
        if(user == null) {
            throw new UsernameNotFoundException( "用户不存在" );
        }

        String authorities = getAuthorities(roleDao.findByRoleId( Integer.valueOf( user.getRoleId() ) ));
        System.out.println(user.getPassword());
        user.setAuthorities( AuthorityUtils.commaSeparatedStringToAuthorityList( authorities ));
        return user;
    }

    public String getAuthorities(Role role) {
        TreeSet<String> all = new TreeSet<String>();
        String[] authorities = role.getAuthorities().split( "," );
        for (String a : authorities) {
            all.add( "ROLE_" + a );
        }
        String auth = new String();

        for (String a : all) {
            auth = auth + a + ",";
        }
        auth = auth.substring( 0, auth.length() - 1 );
        return auth;
    }

}
