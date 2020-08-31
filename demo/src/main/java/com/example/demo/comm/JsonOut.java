package com.example.demo.comm;


import lombok.ToString;

import java.util.HashMap;

/**
 * 返回Json类
 */
//@Data
@ToString
public class JsonOut<T> {
    public static final JsonOut SUCCESS = new JsonOut(200);

    private int code;

    private String msg;
    private T data;

    public JsonOut() {
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        if(data==null){
            return (T)new HashMap(1);
        }
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public JsonOut(T data) {
    	this.code = 200;
    	this.msg = "成功";
		if (data != null) {
			this.data = data;
		}
    }
    

    public JsonOut(int status, String message) {
        this.code = status;
        this.msg = message;
    }
    


    public JsonOut(int status, String message, T data) {
        this.code = status;
        this.msg = message;
        if (data == null) {
//            this.data = new ArrayList<>();
//            this.data =new HashMap();
//            this.data =(T)new HashMap();
//            this.data="{}";
        } else {
            this.data = data;
        }
    }


}
