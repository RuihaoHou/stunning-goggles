package com.qingcheng.entity;

import java.io.Serializable;

/**
 * @author houruihao
 * @date 2020-08-01 22:08
 * @description 返回信息类
 */
public class Result implements Serializable {
    /**
     * 业务返回码 0：成功 1：失败
     */
    private Integer code;
    /**
     * 业务返回信息
     */
    private  String message;

    public Result() {
        this.code = 200;
        this.message = "执行成功";
    }

    public Result(Integer code, String message) {
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
