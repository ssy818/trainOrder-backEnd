package com.ssy.trainorder.entity;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Result<T> {
    private int status;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    @JsonProperty("status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @JsonProperty("msg")
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @JsonProperty("data")
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static <T> Result<T> succ(T data) {
        return succ(200,"操作成功",data);
    }

    public static <T> Result<T> succ(int status,String msg,T data) {
        Result<T> r = new Result<T>();
        r.setStatus(status);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static <T> Result<T> fail(String msg) {
        return fail(400, msg, null);
    }

    public static <T> Result<T> fail(String msg, T data) {
        return fail(400, msg, data);
    }

    public static <T> Result<T> fail(int status,String msg,T data) {
        Result<T> r = new Result<T>();
        r.setStatus(status);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
}
