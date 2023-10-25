package com.classbook.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class User {
    private Integer id;
    private String account;
    private String pwd;

    public User() {
    }

    public User(String account, String pwd) {
        this.account = account;
        this.pwd = pwd;
    }

    public User(Integer id, String account, String pwd) {
        this.id = id;
        this.account = account;
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
