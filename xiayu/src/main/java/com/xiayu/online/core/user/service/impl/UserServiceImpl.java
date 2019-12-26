package com.xiayu.online.core.user.service.impl;

import com.xiayu.online.core.user.dao.UserMapper;
import com.xiayu.online.core.user.entity.User;
import com.xiayu.online.core.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: starc
 * @date: 2019/9/11
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByName(String username) {
        return userMapper.findUserByUserName(username);
    }
}
