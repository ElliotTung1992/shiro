package com.hd.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import java.util.Arrays;


public class ShiroTest {

    @Test
    public void testFirstShiro(){
        // 创建securityManager工厂，通过ini配置文件创建securityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(
                "classpath:shiro-first.ini");
        // 创建SecurityManager
        SecurityManager securityManager = factory.getInstance();
        // 将securityManager设置当前的运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        // 从SecurityUtils里边创建一个subject
        Subject subject = SecurityUtils.getSubject();

        // 在认证提交前准备token（令牌）
        // 这里的账号和密码 将来是由用户输入进去
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan",
                "123");
        subject.login(token);
        try {
            // 执行认证提交
            subject.login(token);
        } catch (AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 是否认证通过
        boolean isAuthenticated = subject.isAuthenticated();
        System.out.println(isAuthenticated);
    }

    @Test
    public void testShiroRealm(){
        // 创建securityManager工厂，通过ini配置文件创建securityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(
                "classpath:shiro-realm.ini");
        // 创建SecurityManager
        SecurityManager securityManager = factory.getInstance();
        // 将securityManager设置当前的运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        // 从SecurityUtils里边创建一个subject
        Subject subject = SecurityUtils.getSubject();

        // 在认证提交前准备token（令牌）
        // 这里的账号和密码 将来是由用户输入进去
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan",
                "123");
        subject.login(token);
        try {
            // 执行认证提交
            subject.login(token);
        } catch (AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 是否认证通过
        boolean isAuthenticated = subject.isAuthenticated();
        System.out.println(isAuthenticated);
    }

    @Test
    public void testShiroRealm111(){
        // 创建securityManager工厂，通过ini配置文件创建securityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(
                "classpath:shiro-2-realm.ini");
        // 创建SecurityManager
        SecurityManager securityManager = factory.getInstance();
        // 将securityManager设置当前的运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        // 从SecurityUtils里边创建一个subject
        Subject subject = SecurityUtils.getSubject();

        // 在认证提交前准备token（令牌）
        // 这里的账号和密码 将来是由用户输入进去
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan",
                "wobuaini");
        subject.login(token);
        try {
            // 执行认证提交
            subject.login(token);
        } catch (AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 是否认证通过
        boolean isAuthenticated = subject.isAuthenticated();
        System.out.println(isAuthenticated);
    }

    @Test
    public void testFirstPShiro(){
        // 创建securityManager工厂，通过ini配置文件创建securityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(
                "classpath:shiro-permission.ini");
        // 创建SecurityManager
        SecurityManager securityManager = factory.getInstance();
        // 将securityManager设置当前的运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        // 从SecurityUtils里边创建一个subject
        Subject subject = SecurityUtils.getSubject();

        // 在认证提交前准备token（令牌）
        // 这里的账号和密码 将来是由用户输入进去
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan",
                "123");
        subject.login(token);
        try {
            // 执行认证提交
            subject.login(token);
        } catch (AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 是否认证通过
        boolean isAuthenticated = subject.isAuthenticated();
        System.out.println(isAuthenticated);

        boolean ishasRole = subject.hasRole("role1");
        System.out.println("单个角色判断" + ishasRole);
        // hasAllRoles是否拥有多个角色
        boolean hasAllRoles = subject.hasAllRoles(Arrays.asList("role1",
                "role2", "role3"));
        System.out.println("多个角色判断" + hasAllRoles);

        // 使用check方法进行授权，如果授权不通过会抛出异常
        // subject.checkRole("role13");

        // 基于资源的授权
        // isPermitted传入权限标识符
        boolean isPermitted = subject.isPermitted("user:create:1");
        System.out.println("单个权限判断" + isPermitted);

        boolean isPermittedAll = subject.isPermittedAll("user:create:1",
                "user:delete");
        System.out.println("多个权限判断" + isPermittedAll);

        // 使用check方法进行授权，如果授权不通过会抛出异常
        subject.checkPermission("items:create:1");
    }

    @Test
    public void testSecoedShiro(){
        // 创建securityManager工厂，通过ini配置文件创建securityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(
                "classpath:shiro-realm2.ini");
        // 创建SecurityManager
        SecurityManager securityManager = factory.getInstance();
        // 将securityManager设置当前的运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        // 从SecurityUtils里边创建一个subject
        Subject subject = SecurityUtils.getSubject();

        // 在认证提交前准备token（令牌）
        // 这里的账号和密码 将来是由用户输入进去
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan",
                "123");
        subject.login(token);
        try {
            // 执行认证提交
            subject.login(token);
        } catch (AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        boolean isPermitted = subject.isPermitted("user:create:1");
        System.out.println("单个权限判断" + isPermitted);

        boolean isPermittedAll = subject.isPermittedAll("user:create:1",
                "user:delete");
        System.out.println("多个权限判断" + isPermittedAll);

        // 使用check方法进行授权，如果授权不通过会抛出异常
        subject.checkPermission("items:add:1");

    }

}
