package com.mhz.history.config.msg;

public class Message {

    private Integer code;

    private Object content;


    public Message(){}

    public Message (Integer code){
        this.code = code;
    }

    public static Message success(){
        return new Message(200);
    }

    public static Message success(Object content){
        return new Message(200,content);
    }

    public static Message error(){
        return new Message(400);
    }

    public static Message error(Object content){
        return new Message(400,content);
    }

    public Message (Integer code,Object content){
        this.code = code;
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
