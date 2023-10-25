package com.classbook.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class School {
    private Integer id;//id
    private String account;//账号
    private String username;//姓名
    private Short gender;//性别
    private String schoolname;//校名
    private String schoolmaster;//校长
    private String classname;//班级
    private String classteacher;//班主任
    private Integer classnumber;//人数
    private String classintro;//班级简介

    public School() {
    }

    public School(Integer id, String account, String username, Short gender, String schoolname, String schoolmaster, String classname, String classteacher, Integer classnumber, String classintro) {
        this.id = id;
        this.account = account;
        this.username = username;
        this.gender = gender;
        this.schoolname = schoolname;
        this.schoolmaster = schoolmaster;
        this.classname = classname;
        this.classteacher = classteacher;
        this.classnumber = classnumber;
        this.classintro = classintro;
    }
}
