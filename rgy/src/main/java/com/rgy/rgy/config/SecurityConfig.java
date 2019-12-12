package com.rgy.rgy.config;

import com.rgy.rgy.service.UserDetailsServiceMy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsUtils;

/**
 * @Author: gaoyk
 * @Date: 2019/11/4 19:29
 * UserDetailsServiceMy 重写loadUserByUsername方法
 * SecurityConfig Security配置类，启用URL过滤，设置PasswordEncoder密码加密类。
 * WebMvcConfig 配置静态资源和解决跨域
 * JwtTokenUtil JWT工具类，生成/验证/是否过期token
 * JwtResponse 生成JWT：服务器的HTTP RESPONSE中将JWT返还
 * JwtRequest 返还JWT：服务器端验证通过，根据从数据库返回的信息，以及预设规则，生成JWT
 * JwtRequestFilter 过滤JWT请求，验证"Bearer token"格式，校验Token是否正确。
 * JwtAuthenticationEntryPoint  实现AuthenticationEntryPoint类，返回认证不通过的信息
 * JwtAuthenticationController，包含登陆和查看token的方法
 */

@CrossOrigin
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private AuthenticationSuccessHandler MyAuthenticationSuccessHandler;
//    @Autowired
//    private AuthenticationFailureHandler MyAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers( CorsUtils::isPreFlightRequest ).permitAll() // 这句比较重要，放过 option 请求
//              .antMatchers("/css/**", "/index").permitAll()
//                  .antMatchers("/template/**").permitAll()
//                  .antMatchers( "/role/**").hasRole( "10" )
                //                .anyRequest().authenticated()    //操作必须是已登录状态
                .and()
               // .formLogin()
                //                           .loginPage("/login").permitAll()
//                  .loginProcessingUrl( "/login" ).usernameParameter("name").passwordParameter("password")
//                  .successHandler( MyAuthenticationSuccessHandler )
//                  .failureHandler( MyAuthenticationFailureHandler )
                //.and()
                .csrf().disable();

    }

    @Autowired
    UserDetailsServiceMy myUserDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService( myUserDetailsService ).passwordEncoder( passwordEncoder() );
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
//
//
//
//    @Autowired
//    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//    @Autowired
//    private UserDetailsService jwtUserDetailsService;
//    @Autowired
//    private JwtRequestFilter jwtRequestFilter;
//
//
//    @Value("${jwt.header}")
//    private String tokenHeader;
//
//    @Value("${jwt.route.authentication.path}")
//    private String authenticationPath;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        // configure AuthenticationManager so that it knows from where to load
//        // user for matching credentials
//        // Use BCryptPasswordEncoder
//        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        System.out.println("authenticationPath:"+authenticationPath);
//        // We don't need CSRF for this example
//        httpSecurity.csrf().disable()
//                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
//                .sessionCreationPolicy( SessionCreationPolicy.STATELESS)
//                // dont authenticate this particular request
//                .and()
//                .authorizeRequests()
//                .antMatchers(authenticationPath).permitAll()
//                .anyRequest().authenticated()
//
//                .and()
//                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//
//        // disable page caching
//        httpSecurity
//                .headers()
//                .frameOptions().sameOrigin()  // required to set for H2 else H2 Console will be blank.
//                .cacheControl();
//    }
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // AuthenticationTokenFilter will ignore the below paths
//        web
//                .ignoring()
//                .antMatchers(
//                        HttpMethod.POST,
//                        authenticationPath
//                )
//
//                // allow anonymous resource requests
//                .and()
//                .ignoring()
//                .antMatchers(
//                        HttpMethod.GET,
//                        "/",
//                        "/*.html",
//                        "/favicon.ico"
//
//
//}



