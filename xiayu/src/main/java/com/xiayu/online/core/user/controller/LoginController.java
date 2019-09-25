package com.xiayu.online.core.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: test_
 * @date: 2019/8/27
 */
@RestController
@RequestMapping("user")
public class LoginController {

    @GetMapping("login")
    public String login(String username, String password) {
        try{
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken uptoken = new
                    UsernamePasswordToken(username,password);
            subject.login(uptoken);
            return "登录成功";
        }catch (Exception e) {
            return "用户名或密码错误";
        }
    }
}
