package com.classbook.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;//id
    private Integer schoolid;//学校id
    private String name;//姓名
    private Short gender;//性别
    private Integer age;//年龄
    private String birthday;//生日
    private String constellation;//星座
    private String zodiac;//生肖
    private String wechat;//微信
    private String qq;//QQ
    private String phone;//手机号
    private String address;//地址
    private String nickname;//别名
    private String color;//颜色
    private String course;//学科
    private String fruit;//水果
    private String animal;//动物
    private String idol;//偶像
    private String msg;//留言
}
