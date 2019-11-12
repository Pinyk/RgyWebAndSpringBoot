package com.rgy.rgy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 角色
 * @Author: Silvia
 * @Date: 2019/11/6  22:49
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    private int roleId;

    @Column(name = "roleName")
    private String roleName;

    @Column(name = "roleNote")
    private String roleNote;

    @Column(name = "infoState")
    private int infoState;

    public Role(String roleName, String roleNote, int infoState) {
        this.roleName = roleName;
        this.roleNote = roleNote;
        this.infoState = infoState;
    }
}
