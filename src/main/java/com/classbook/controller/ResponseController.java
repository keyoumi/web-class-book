package com.classbook.controller;

import com.classbook.bean.Result;
import com.classbook.demo.Address;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ResponseController {

    @RequestMapping("/helloWorld")
    public Result hello() {
        return Result.success("Hello Hello");
    }

    //返回对象：get请求 http://localhost:8080/getAddr
    @RequestMapping("/getAddr")
    public Result getAddr() {
        Address address = new Address("广东", "深圳");
        return Result.success(address);
    }

    //postman模拟：get请求 http://localhost:8080/listAddr
    @RequestMapping("/listAddr")
    public Result listAddr() {
        ArrayList<Address> arrayList = new ArrayList<>();
        Address address1 = new Address("福建", "厦门");
        Address address2 = new Address("广东", "深圳");
        Address address3 = new Address("江西", "赣州");
        arrayList.add(address1);
        arrayList.add(address2);
        arrayList.add(address3);
        return Result.success(arrayList);
    }

}
