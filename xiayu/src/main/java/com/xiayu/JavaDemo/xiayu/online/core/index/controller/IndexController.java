package com.xiayu.JavaDemo.xiayu.online.core.index.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: test_
 * @date: 2019/8/27
 */
@RestController
@RequestMapping("xiayu")
public class IndexController {

    @GetMapping("index")
    public String index() {
        return "xiayu's index";
    }
}
