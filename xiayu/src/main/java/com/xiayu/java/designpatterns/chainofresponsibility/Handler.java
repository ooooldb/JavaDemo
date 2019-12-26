package com.xiayu.java.designpatterns.chainofresponsibility;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public abstract class Handler {
    private Handler nextHandler;
    public final Response handlerMessage(Request request){
        Response response=null;
        if(getHandlerLevel().equals(request.getRequestLevel())){
            response=echo(request);
        }else {
            if(nextHandler!=null){
                response=nextHandler.handlerMessage(request);
            }else {

            }
        }
        return response;
    }
    public void setNext(Handler _handler){
        this.nextHandler=_handler;
    }
    protected abstract Level getHandlerLevel();
    protected abstract Response echo(Request request);
}
