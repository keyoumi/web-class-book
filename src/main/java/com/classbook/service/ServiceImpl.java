package com.classbook.service;

import com.classbook.bean.Result;
import com.classbook.bean.School;
import com.classbook.bean.Student;
import com.classbook.bean.User;

import java.util.ArrayList;
import java.util.List;

public interface ServiceImpl {
    //获取员工列表
    public List<User> listUser();

    User login(User loginUser);

    void register(String account, String pwd);

    User queryUser(String account);

    void updatePwd(String account, String pwd);

    public void createSchool(School school);

    int querySchoolCount(String account);

    ArrayList<School> queryschool(String account);

    void classmate(Student student);

    ArrayList<Student> queryclassmatelist(String schoolId);

    Student queryclassmate(String classmateid);

}
