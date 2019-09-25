package com.xiayu.java.designpatterns.command;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    public void action(){
        command.excute();
    }
}
