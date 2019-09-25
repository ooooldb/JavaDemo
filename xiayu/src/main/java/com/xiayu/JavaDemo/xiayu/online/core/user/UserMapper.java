package com.xiayu.JavaDemo.xiayu.online.core.user;

import com.xiayu.JavaDemo.xiayu.online.core.user.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author: starc
 * @date: 2019/9/22
 */

public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User findUserByUserName(String username);
}
