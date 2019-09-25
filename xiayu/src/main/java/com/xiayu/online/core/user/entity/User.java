package com.xiayu.online.core.user.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体类
 */
@Getter
@Setter
/**
 * AuthCachePrincipal:
 *  redis和shiro插件包提供的接口
 */
public class User implements Serializable {
    private static final long serialVersionUID = 4297464181093070302L;
    private String id;
    private String username;
    private String password;

    private Set<Role> roles = new HashSet<Role>();//用户与角色   多对多

    /*@Override
    ,AuthCachePrincipal
    public String getAuthCacheKey() {
        return null;
    }*/
}
