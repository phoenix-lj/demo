package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping(value = "/getUser" ,method = {RequestMethod.POST,RequestMethod.GET})
    public String getUser(int id){
        System.out.println("测试合并");
        System.out.println("测试回退版本");
        return "";
    }
}
