package com.maitianer.shirodemo.config;

import com.maitianer.shirodemo.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zhou
 * @Date: 2019/06/26 14:53
 */
@Configuration
public class ShiroConfig {
    /**
     * 1. 创建ShiroFilterFactoryBean;
     */
    @Bean(name="shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //添加shiro的过滤器
        //shiro的内置过滤器：可以实现权限的相关拦截
        //常用的过滤器：
        //1.anno：无需认证（登陆即可访问）
        //2.authc：必须认证才可以访问
        //3.user：如果使用remanberMe的功能就可以直接访问
        //4.perms：该资源必须得到资源权限才可以访问
        //5.role：该资源必须得到角色权限才可以访问
//        Map filterMap = new HashMap();
//
//        //必须登陆才可以访问
//        //设置哪些页面必须授权后才可以登陆
//        filterMap.put("/user/student","perms[2]");//学生页面
//        filterMap.put("/user/teacher","perms[1]");//老师页面
//        filterMap.put("/user/index","authc");//首页
//
//        //被拦截后跳转登陆页面
//        shiroFilterFactoryBean.setLoginUrl("/user/login ");
//        //未授权跳转页面
//        shiroFilterFactoryBean.setUnauthorizedUrl("/user/unAuth");
//        //将filterMap中的url和相关权限交给shiro框架管理
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }
    /**
     * 2. 创建DefaultWebSecurityManager;
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm)
    {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //关联realm
        securityManager.setRealm(userRealm);

        return securityManager;
    }
    /**
     * 3. 创建Realm;
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }
    /**
     * 配置shiroDialect，用于thymeleaf和shiro标签配合使用
     */
//    @Bean
//    public ShiroDialect getShiroDialect() {
//        return new ShiroDialect();
//    }
}
