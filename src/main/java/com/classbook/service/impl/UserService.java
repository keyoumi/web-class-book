package com.classbook.service.impl;

import com.classbook.bean.School;
import com.classbook.bean.Student;
import com.classbook.bean.User;
import com.classbook.dao.impl.UserDao;
import com.classbook.mapper.UserMapper;
import com.classbook.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary //方式1：有两个@Service的类时，只有加了这个Primary的才会生效。
@Service
public class UserService implements ServiceImpl {

//    @Autowired
//    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser() {
        List<User> users = userMapper.listUser();
        //数据逻辑处理A
        return users;
    }

    @Override
    public User login(User loginUser) {
        User user = userMapper.queryUserByAccountAndPwd(loginUser.getAccount(), loginUser.getPwd());
        System.out.println("UserController result user：" + user);
        return user;
    }

    @Override
    public void register(String account, String pwd) {
        userMapper.insertAccount(account, pwd);
    }

    @Override
    public User queryUser(String account) {
        return userMapper.queryUserBy(account);
    }

    @Override
    public void updatePwd(String account, String pwd) {
        userMapper.updatePwd(account, pwd);
    }

    public void createSchool(School school) {
        userMapper.insetSchool(school);
    }

    @Override
    public int querySchoolCount(String account) {
        return userMapper.querySchoolCount(account);
    }

    @Override
    public ArrayList<School> queryschool(String account) {
        return userMapper.querySchoolList(account);
    }

    @Override
    public void classmate(Student student) {
        userMapper.insertStudent(student);
    }

    @Override
    public ArrayList<Student> queryclassmatelist(String schoolid) {
        return userMapper.queryclassmatelist(schoolid);
    }

    @Override
    public Student queryclassmate(String classmateid) {
        return userMapper.queryclassmate(classmateid);
    }
}
