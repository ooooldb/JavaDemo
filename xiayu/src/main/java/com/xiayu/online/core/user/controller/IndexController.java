package com.xiayu.online.core.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: test_
 * @date: 2019/8/27
 */
@RestController
@RequestMapping("index")
public class IndexController {

    @GetMapping("unProtect")
    public String index() {
        return "都可访问";
    }

    @GetMapping("protect")
    public String protect() {
        return "需登录后访问";
    }
}
