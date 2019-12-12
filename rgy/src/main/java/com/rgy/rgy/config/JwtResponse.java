package com.rgy.rgy.config;//package com.rgy.rgy.bean;

/**
 * @Author: Silvia
 * @Date: 2019/12/9  22:53
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String jwttoken;
    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public void setJwttoken(String jwttoken) {
        this.jwttoken = jwttoken;
    }
}