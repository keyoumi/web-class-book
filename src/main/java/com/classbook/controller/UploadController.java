package com.classbook.controller;

import com.classbook.bean.Result;
import com.classbook.bean.School;
import com.classbook.bean.Student;
import com.classbook.bean.User;
import com.classbook.service.impl.UserService;
import com.classbook.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class UploadController {
    @Autowired
    private UserService userService;

    //返回对象：get请求 http://localhost:8080/listEmp
    //http://localhost:8080/demo3/emp.html
    @GetMapping("/listEmp")
    public Result listEmp() {
        //请求、响应数据
        return Result.success(userService.listUser());
    }

    @PostMapping("/login")
    public Result login(@RequestBody User loginUser) {
        System.out.println("UserController loginUser：" + loginUser);
        //请求、响应数据
        User user = userService.login(loginUser);
        if (user == null) {
            return Result.error("用户名或密码错误！");
        } else {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("id", loginUser.getId());
            hashMap.put("account", loginUser.getAccount());
            //hashMap.put("pwd", loginUser.getPwd());
            String jwtString = JwtUtils.generateJwt(hashMap);
            System.out.println("UserController 登录请求生成了JWT令牌。");
            return Result.success(jwtString);
        }
    }

    @PostMapping("/register")
    public Result register(@RequestParam(name = "account", required = true) String account,
                           @RequestParam(name = "pwd", required = true) String pwd,
                           @RequestParam(name = "vercode", required = true) String vercode) {
        System.out.println("UserController register：" + account + " pwd" + pwd + " vercode:" + vercode);
        //todo 判断验证码是否正确
        userService.register(account, pwd);
        //return Result.error("用户名或密码错误！");
        return Result.success("");
    }

    @PostMapping("/reset")
    public Result reset(@RequestParam(name = "account", required = true) String account,
                           @RequestParam(name = "pwd", required = true) String pwd,
                           @RequestParam(name = "vercode", required = true) String vercode) {
        System.out.println("UserController register：" + account + " pwd" + pwd + " vercode:" + vercode);
        //todo 判断验证码是否正确
        User user = userService.queryUser(account);
        if (user != null) {
            if (user.getPwd().equals(pwd)) {
                //密码没改过。
                return Result.success("密码重置成功");
            }
            userService.updatePwd(user.getAccount(), pwd);
            return Result.success("密码重置成功");
        }
        return Result.error("密码重置失败");
    }

    @RequestMapping("/createschool")
    public Result createSchool(@RequestBody School school,HttpServletRequest request, HttpServletResponse response) {
        System.out.println("createSchool 接收到的school对象信息：" + school);
        String jwt = request.getHeader("token");
        System.out.println("createSchool 接收到的token,jwt：" + jwt);
        Claims claims = JwtUtils.parseJwt(jwt);
        String account = (String) claims.get("account");
        System.out.println("createSchool 接收到的account：" + account);
        int count = userService.querySchoolCount(account);
        if (school == null || !StringUtils.hasLength(account)|| count >= 5){
            return Result.error("创建的学校班级数量超过限制！");
        }
        if (!account.equals(school.getAccount())) {
            return Result.error("学校班级创建失败,清除缓存后再试！");
        }
        userService.createSchool(school);
        return Result.success("学校班级创建成功！");
    }

    @RequestMapping("/queryschool")
    public Result queryschool(@RequestParam(name = "account", required = true) String account
            ,HttpServletRequest request, HttpServletResponse response) {
        System.out.println("queryschool 接收到的account信息：" + account);
        String jwt = request.getHeader("token");
        System.out.println("queryschool 接收到的token,jwt：" + jwt);
        Claims claims = JwtUtils.parseJwt(jwt);
        String tokenAccount = (String) claims.get("account");
        System.out.println("queryschool 接收到的tokenAccount：" + tokenAccount);

        if (!tokenAccount.equals(account)) {
            //查询账号与登录账号不一致。
            return Result.error("请稍后再试！");
        }
        ArrayList<School> list =  userService.queryschool(account);
        return Result.success(list);
    }

    @RequestMapping("/classmate")
    public Result classmate(@RequestBody Student student, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("classmate 接收到的student对象信息：" + student);
        String jwt = request.getHeader("token");
        System.out.println("classmate 接收到的token,jwt：" + jwt);
        Claims claims = JwtUtils.parseJwt(jwt);
        String account = (String) claims.get("account");
        System.out.println("classmate 接收到的account：" + account);
        userService.classmate(student);
        return Result.success("同学留念成功！");
    }

    @RequestMapping("/queryclassmatelist")
    public Result queryclassmatelist(@RequestParam(name = "schoolid", required = true) String schoolid
            ,HttpServletRequest request, HttpServletResponse response) {
        System.out.println("queryclassmatelist 接收到的schoolId信息：" + schoolid);
        String jwt = request.getHeader("token");
        System.out.println("queryclassmatelist 接收到的token,jwt：" + jwt);
        Claims claims = JwtUtils.parseJwt(jwt);
        String tokenAccount = (String) claims.get("account");
        System.out.println("queryclassmatelist 接收到的tokenAccount：" + tokenAccount);

        ArrayList<Student> list =  userService.queryclassmatelist(schoolid);
        return Result.success(list);
    }

    @RequestMapping("/queryclassmate")
    public Result queryclassmate(@RequestParam(name = "classmateid", required = true) String classmateid,
                                 HttpServletRequest request, HttpServletResponse response) {
        System.out.println("queryclassmate 接收到的classmateid信息：" + classmateid);
        String jwt = request.getHeader("token");
        System.out.println("queryclassmate 接收到的token,jwt：" + jwt);
        Claims claims = JwtUtils.parseJwt(jwt);
        String tokenAccount = (String) claims.get("account");
        System.out.println("queryclassmate 接收到的tokenAccount：" + tokenAccount);

        Student student =  userService.queryclassmate(classmateid);
        return Result.success(student);
    }

}
