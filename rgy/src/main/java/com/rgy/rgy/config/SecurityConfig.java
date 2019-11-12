package com.rgy.rgy.config;

import com.rgy.rgy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: gaoyk
 * @Date: 2019/11/4 19:29
 */

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .passwordEncoder(passwordEncoder)
//                .withUser("admin")
//                .password("123456")
//                .roles("USER","ADMIN")
//                .and()
//                .withUser("pinyk")
//                .password("123")
//                .roles("USER");
//        auth.userDetailsService(new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                User user = userService.getUserByName(username);
//                if(user == null){
//                    throw new UsernameNotFoundException("用户名不存在");
//                }
//                return (UserDetails) user;
//            }
//        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/template/**").permitAll()
//                .anyRequest().authenticated()    //操作必须是已登录状态
                .and()
                .formLogin()
                .loginPage("/user/login1")
                .and()
                .csrf().disable()
                .httpBasic();
    }
}
