package com.classbook.dao.impl;

import com.classbook.bean.User;
import com.classbook.dao.UserDaoImpl;
import com.classbook.mapper.UserMapper;
import com.classbook.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository //("daoA") //生成的对象名默认为首字母小写，为empDaoA。括号里的可以自定以为daoA
public class UserDao implements UserDaoImpl {
    @Override
    public List<User> listUser() {
        //数据获取
        String file = this.getClass().getClassLoader().getResource("user.xml").getFile();
        List<User> userList = XmlParserUtils.parse(file, User.class);
        return userList;
    }

}
