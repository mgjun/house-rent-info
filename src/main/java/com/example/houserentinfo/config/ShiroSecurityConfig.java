package com.example.houserentinfo.config;


import com.example.houserentinfo.service.impl.MyShiroRealm;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@Slf4j
public class ShiroSecurityConfig {
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        log.info("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
//        filterChainDefinitionMap.put("/static/**", "anon");
//        filterChainDefinitionMap.put("/**/*.html", "anon");
//        filterChainDefinitionMap.put("/**/*.css", "anon");
//        filterChainDefinitionMap.put("/**/*.js", "anon");
//        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/v1/api/**", "authc");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
//        shiroFilterFactoryBean.setLoginUrl("/test/login");
//        shiroFilterFactoryBean.setSuccessUrl("/index");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }


    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        SecurityUtils.setSecurityManager(securityManager);
        return securityManager;
    }

}
