package com.xiayu.JavaDemo.xiayu.java.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: starc
 * @date: 2019/2/21
 */

@Controller
public class LoginController {

    @RequestMapping("login")
    public String login() {
        System.out.println("get request");
        return "";
    }
}
