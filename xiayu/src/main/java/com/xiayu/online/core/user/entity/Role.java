package com.xiayu.online.core.user.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Role implements Serializable {
    private static final long serialVersionUID = 594829320797158219L;
    private String id;
    private String name;
    private String description;

    //角色与用户   多对多
    private Set<User> users = new HashSet<User>(0);

    //角色与权限  多对多
    private Set<Permission> permissions = new HashSet<Permission>(0);
}