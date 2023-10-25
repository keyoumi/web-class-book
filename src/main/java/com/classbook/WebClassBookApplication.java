package com.classbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WebClassBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebClassBookApplication.class, args);
    }

}
