package com.example.demo.controller;

import com.example.demo.dto.Student;
import com.example.demo.dto.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class HelloController {


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello world";
    }

    @RequestMapping(value = "/getUser" ,method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public String getUser(@RequestBody List<User> user) throws IOException, ServletException {

        return user.toString();
    }

    @RequestMapping(value = "/pathParam/{id}" ,method = {RequestMethod.POST})
    public String getUser(@PathVariable String id) throws IOException, ServletException {
        return id;
    }
    @RequestMapping(value = "/arrayTest",method = RequestMethod.POST)
    public String arrayTest(@RequestParam(value = "arrays",required = false) List<String> arrays,HttpServletRequest httpServletRequest){


        System.out.println(httpServletRequest.getParameter("id"));
        return arrays.toString();
    }

    @RequestMapping(value = "/getStudent",method = RequestMethod.POST)
    public String getStudent(@RequestBody(required = false) Student student){

        return student == null ? "sutdent is null" : student.toString();
    }

    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public String uploadFile(MultipartFile file) throws IOException {
        Path path = Paths.get("D:/upload/",file.getOriginalFilename());
        Files.write(path,file.getBytes());
        return "OK";
    }

}
