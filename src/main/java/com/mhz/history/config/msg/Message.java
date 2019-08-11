package com.mhz.history.config.msg;

public class Message {

    private Integer code;

    private String message;

    public Message(){}

    public Message (Integer code){
        this.code = code;
    }

    public static Message success(){
        return new Message(200);
    }

    public static Message success(String message){
        return new Message(200,message);
    }

    public static Message error(){
        return new Message(400);
    }

    public static Message error(String message){
        return new Message(400,message);
    }

    public Message (Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
