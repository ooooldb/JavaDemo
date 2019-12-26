package com.xiayu.online.core.user.controller;

import com.xiayu.online.core.user.service.WSMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/message")
public class MessageController{
    //websocket服务层调用类
    @Autowired
    private WSMessageService wsMessageService;

    //请求入口
    @RequestMapping(value="/TestWS",method= RequestMethod.GET)
    @ResponseBody
    public String TestWS(@RequestParam(value="userId",required=true) Long userId,
                         @RequestParam(value="message",required=true) String message){
        log.info("收到发送请求，向用户{}的消息：{}",userId,message);
        if(wsMessageService.sendToAllTerminal(userId, message)){
            return "发送成功";
        }else{
            return "发送失败";
        }
    }

    //请求入口
    @RequestMapping(value="/sendMessageTest",method= RequestMethod.GET)
    @ResponseBody
    public String sendMessageTest(){
        Long userId = 22L;
        String message = "Hello!你好啊";

        log.info("收到发送请求，向用户{}的消息：{}",userId,message);
        if(wsMessageService.sendToAllTerminal(userId, message)){
            return "发送成功";
        }else{
            return "发送失败";
        }
    }
}