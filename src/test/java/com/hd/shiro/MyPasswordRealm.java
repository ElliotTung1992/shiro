package com.hd.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.ArrayList;
import java.util.List;

public class MyPasswordRealm extends AuthorizingRealm{

    @Override
    public void setName(String name) {
        super.setName("MyPasswordRealm");
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userCode = token.getPrincipal().toString();
//        String password = "b8560c8591060df97f79977f86398e55";
        String password = "123";
        String aslt = "no";
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userCode, password, ByteSource.Util.bytes(aslt), this.getName());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userCode, password, this.getName());
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String  userCode = (String) principalCollection.getPrimaryPrincipal();
        List<String> permissions = new ArrayList<String>();
        permissions.add("user:create");//用户的创建
        permissions.add("items:add");//商品添加权限

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }
}
