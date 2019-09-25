package com.xiayu.online.core.user.service;

import com.xiayu.online.core.user.entity.User;

/**
 * @author: starc
 * @date: 2019/9/11
 */
public interface UserService {
    User findByName(String name);
}
