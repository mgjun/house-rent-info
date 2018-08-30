package com.example.houserentinfo.service.impl;


import com.example.houserentinfo.entity.TblAccess;
import com.example.houserentinfo.entity.TblRole;
import com.example.houserentinfo.entity.TblUser;
import com.example.houserentinfo.service.TblUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm extends AuthorizingRealm {


    @Autowired
    private TblUserService tblUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = (String)principals.getPrimaryPrincipal();
        TblUser userInfo = tblUserService.findByUserName(username);
        TblRole role = userInfo.getTblRole();
        authorizationInfo.addRole(role.getRoleName());
        for(TblAccess p:role.getTblAccessList()){
            authorizationInfo.addStringPermission(p.getAccessUrl());
        }


        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        TblUser userInfo = tblUserService.findByUserName(usernamePasswordToken.getUsername());

        if (userInfo == null) {
            return null;
        }

        return new SimpleAuthenticationInfo(
                usernamePasswordToken.getUsername(),
                userInfo.getPassword(),
//                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
                getName());
    }
}
