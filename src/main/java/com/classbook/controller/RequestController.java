package com.classbook.controller;

import com.classbook.bean.School;
import com.classbook.demo.ChinaUser;
import com.classbook.bean.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class RequestController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    //postman模拟：get请求 http://localhost:8080/simpleParamOne?username=admin&password=huang123
    @RequestMapping("/simpleParamOne")
    public String helloOne(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return "Hello 通过request获取："+ username + password;
    }


    //postman模拟：get请求 http://localhost:8080/simpleParamTwo?username=admin&password=huang123
    @RequestMapping("/simpleParamTwo")
    public String helloTwo(String username, String password) {
        return "Hello,直接接收参数："+ username + password;
    }

    //postman模拟：get请求 http://localhost:8080/simpleParamThree?name=admin&pwd=huang123
    //postman模拟：post请求 http://localhost:8080/simpleParamThree  参数放body的x-www-dorm-urlencoded中
    @RequestMapping("/simpleParamThree")
    public String helloThree(@RequestParam(name = "name") String username, @RequestParam(name = "pwd") String password) {
        return "Hello,RequestParam指定必传参数，且使用name、pwd作为key："+ username + password;
    }

    //postman模拟：get请求 http://localhost:8080/simpleParamFour?username=admin&password=huang123
    @RequestMapping("/simpleParamFour")
    public String helloFour(User user) {
        System.out.println("接收到的User对象信息：" + user);
        return "Hello,接收对象："+ user;
    }

    //postman模拟：get请求 http://localhost:8080/simpleParamFive?username=admin&password=huang123&address.province=beijing&address.city=beijing
    @RequestMapping("/simpleParamFive")
    public String helloFive(ChinaUser user) {
        System.out.println("接收到的ChinaUser对象信息：" + user);
        return "Hello,接收到的嵌套对象的信息："+ user;
    }


    //postman模拟：get请求 http://localhost:8080/simpleParamSix?hobby=game&hobby=java&hobby=sing
    @RequestMapping("/simpleParamSix")
    public String helloSix(String[] hobby) {
        System.out.println("接收到的信息：" + Arrays.toString(hobby));
        return "Hello,接收到数组的信息："+ Arrays.toString(hobby);
    }


    //postman模拟：get请求 http://localhost:8080/simpleParamSeven?hobby=game&hobby=java&hobby=sing
    @RequestMapping("/simpleParamSeven")
    public String helloSeven(@RequestParam List<String> hobby) {
        System.out.println("接收的信息：" + hobby);
        return "Hello,接收到集合的信息："+ hobby;
    }

    //postman模拟：get请求 http://localhost:8080/simpleParamEight?updateTime=2023-12-13 10:05:45
    @RequestMapping("/simpleParamEight")
    public String helloEight(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println("接收的信息：" + updateTime);
        return "Hello,接收到日期参数的信息,DateTimeFormat指定传递的格式，updateTime："+ updateTime;
    }

    //postman模拟：Post请求 http://localhost:8080/simpleParamNine 参数放body的raw中，且数据格式选择为json
    /*
    {
    "username":"admin",
    "password":"hzc123",
    "address":{
        "province":"beijing",
        "city":"beijing"
        }
    }
    * */
    @RequestMapping("/simpleParamNine")
    public String helloNine(@RequestBody ChinaUser user) {
        System.out.println("接收的信息：" + user);
        return "Hello,接收到Json的信息："+ user;
    }

    //postman模拟：get请求 http://localhost:8080/simpleParamTen/1
    @RequestMapping("/simpleParamTen/{id}")
    public String helloTen(@PathVariable Integer id) {
        System.out.println("接收的信息id：" + id);
        return "Hello,接收路径参数的信息id："+ id;
    }

    //postman模拟：get请求 http://localhost:8080/simpleParamEleven/1/tom
    @RequestMapping("/simpleParamEleven/{id}/{name}")
    public String helloTen(@PathVariable Integer id, @PathVariable String name) {
        System.out.println("接收的信息id：" + id + " name:" + name);
        return "Hello,接收多个路径参数的信息id："+ id + " name:" + name;
    }

    //------------------------------------------------------------------------------------------------


}
