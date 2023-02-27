package com.anofinda.anoblog.config;

import com.anofinda.anoblog.shiro.UserRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dongyudeng
 */
@Configuration
public class ShiroConfiguration {
    @Bean
    public UserRealm getUserRealm() {
        return new UserRealm();
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        //需要使用LinkedHashMap保证filter的拦截顺序
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/api/admin/login", "anon");
        filterChainDefinitionMap.put("/api/admin/**", "authc");
        definition.addPathDefinitions(filterChainDefinitionMap);
        return definition;
    }
}
