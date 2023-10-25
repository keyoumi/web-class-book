package com.classbook.controller;

import com.classbook.bean.User;
import com.classbook.demo.ChinaUser;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class IndexController {

    @GetMapping("/index")
    public String indexStart() {
        return "index";
    }

}
