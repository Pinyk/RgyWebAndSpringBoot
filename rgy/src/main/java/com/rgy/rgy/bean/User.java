package com.rgy.rgy.bean;

/**
 * 用户
 * @Author: Silvia
 * @Date: 2019/11/6  22:49
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "realName")
    private String realName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "roleId")
    private int roleId;
    @Column(name = "infoState")
    private int infoState;

    public User(String userName, String password, String realName, String phone, int roleId, int infoState) {
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.phone = phone;
        this.roleId = roleId;
        this.infoState = infoState;
    }

}
