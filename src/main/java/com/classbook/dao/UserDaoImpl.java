package com.classbook.dao;

import com.classbook.bean.User;

import java.util.List;

public interface UserDaoImpl {
    //获取员工列表数据
    List<User> listUser();
}
