package com.xiayu.JavaDemo.xiayu.online.common.config.shiro;

import com.xiayu.JavaDemo.xiayu.online.core.user.entity.Permission;
import com.xiayu.JavaDemo.xiayu.online.core.user.entity.Role;
import com.xiayu.JavaDemo.xiayu.online.core.user.entity.User;
import com.xiayu.JavaDemo.xiayu.online.core.user.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @author: starc
 * @date: 2019/9/11
 */
public class CustomRealm extends AuthorizingRealm {
    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }

    @Autowired
    private UserService userService;

    /**
     * 构造授权方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection
                                                               principalCollection) {
        /*
        Shiro的配置
         */
        //SecurityManager 是 Shiro 架构的心脏，用于协调内部的多个组件完成全部认证授权的过程。例如通过调用realm
        //完成认证与登录。使用基于springboot的配置方式完成SecurityManager，Realm的装配
        //1.获取认证的用户数据
        User user = (User) principalCollection.getPrimaryPrincipal();
        //2.构造认证数据
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            //添加角色信息
            info.addRole(role.getName());
            for (Permission permission : role.getPermissions()) {
                //添加权限信息
                info.addStringPermission(permission.getCode());
            }
        }
        return info;
    }

    /**
     * 认证方法
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken
                                                                 authenticationToken) throws AuthenticationException {
        //1.获取登录的upToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        //2.获取输入的用户名密码
        String username = upToken.getUsername();
        String password = new String(upToken.getPassword());
        //3.数据库查询用户
        User user = userService.findByName(username);
        //4.用户存在并且密码匹配存储用户数据
        if (user != null && user.getPassword().equals(password)) {
            return new
                    SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
        } else {
            //返回null会抛出异常，表明用户不存在或密码不匹配
            return null;
        }
    }
}