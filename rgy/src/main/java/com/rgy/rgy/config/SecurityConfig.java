package com.rgy.rgy.config;

import com.rgy.rgy.service.UserDetailsServiceMy;
import com.rgy.rgy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author: gaoyk
 * @Date: 2019/11/4 19:29
 */


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/template/**").permitAll()
//                .anyRequest().authenticated()    //操作必须是已登录状态
//                .and()
//                .formLogin()
                //.loginPage("/index.html").permitAll()
                .and()
                .csrf().disable();
                //.httpBasic();
    }
    @Autowired
    UserDetailsServiceMy myUserDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService( myUserDetailsService ).passwordEncoder( passwordEncoder() );
    }

    private PasswordEncoder passwordEncoder() {
        return new MyPasswordEncoder();
        //return new BCryptPasswordEncoder();
    }


    public class MyPasswordEncoder implements PasswordEncoder {
        @Override
        public String encode(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override
        public boolean matches(CharSequence charSequence, String s) {
            return s.equals(charSequence.toString());
        }
    }

}

