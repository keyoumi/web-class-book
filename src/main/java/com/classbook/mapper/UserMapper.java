package com.classbook.mapper;

import com.classbook.bean.School;
import com.classbook.bean.Student;
import com.classbook.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;
//在运行时，会自动生成该接口的实现类对象（代理对象），并且将该对象交给IOC容器管理
@Mapper
public interface UserMapper {

    public List<User> listUser();

    public User queryUserByAccountAndPwd(String account, String pwd);

    public void insertAccount(String account, String pwd);

    User queryUserBy(String account);

    void updatePwd(String account, String pwd);

    void insetSchool(School school);

    int querySchoolCount(String account);

    ArrayList<School> querySchoolList(String account);

    void insertStudent(Student student);

    ArrayList<Student> queryclassmatelist(String schoolid);

    Student queryclassmate(String classmateid);
}
