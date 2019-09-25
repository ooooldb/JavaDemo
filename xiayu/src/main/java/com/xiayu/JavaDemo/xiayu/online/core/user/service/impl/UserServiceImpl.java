package com.xiayu.JavaDemo.xiayu.online.core.user.service.impl;

import com.xiayu.JavaDemo.xiayu.online.core.user.UserMapper;
import com.xiayu.JavaDemo.xiayu.online.core.user.entity.User;
import com.xiayu.JavaDemo.xiayu.online.core.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: starc
 * @date: 2019/9/11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String username) {
        return userMapper.findUserByUserName(username);
    }
}
