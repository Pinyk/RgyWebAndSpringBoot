package com.rgy.rgy.bean;
import lombok.Data;

/**
 * @Author: gaoyk
 * @Date: 2019/10/30 16:12
 */
@Data
public class Result {
    private String status;

    private String msg;

    private Object data;

    public Result(String status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Result(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
