package com.classbook;

import com.classbook.bean.User;
import com.classbook.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class WebClassBookApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void queryList(){
        List<User> userList = userMapper.listUser();
        System.out.println("queryList userList:" + userList);
    }

    @Test
    public void queryUserByAccountAndPwd(){
        User user = userMapper.queryUserByAccountAndPwd("13691536233","huang123");
        System.out.println("queryUserByAccountAndPwd user:" + user);
    }

}
