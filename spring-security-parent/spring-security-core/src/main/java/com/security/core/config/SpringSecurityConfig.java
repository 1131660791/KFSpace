package com.security.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * security 提供了 WebSecurityConfigurerAdapter 适配器，抽象类。
 * EnableWebSecurity 开启security 过滤链 Filter
 */
@Slf4j
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 指定加密方式
     * security 5 后 官方推荐使用 BCryptPasswordEncoder 它在原来的密码基础上加入 一个不定的 值 让 密码更安全
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 认证管理器：
     * 1：认证信息 （账号，密码） 默认账户为:user 密码 控制台产生的加密 密码
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 加密密码
        String passwordStr = passwordEncoder().encode("123456");
        // 指定账号密码和登录 账号: withUser 密码（加密不加密会报错）：  password 权限标识 ： authorities
        auth.inMemoryAuthentication().withUser("admin").password(passwordStr).authorities("administrator");
        log.error("密码加密后为:"+passwordStr);
    }

    /**
     * 资源权限认证
     * 1：被拦截的资源
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 使用 httpBasic 方式认证
                .httpBasic()
                // 使用 表单 方式认证
//                .formLogin()
                //  连接符
                .and()
                // 认证的i请求
                .authorizeRequests()
                // 所有访问该应用的请求
                .anyRequest()
                // 都要通过认证才能访问
                .authenticated();
    }
}
