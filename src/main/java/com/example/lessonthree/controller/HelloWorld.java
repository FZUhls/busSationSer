package com.example.lessonthree.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/hello")
public class HelloWorld {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        System.out.println("1111111111111111111111111111111");
        return "HelloWorld";
    }
    @RequestMapping(value = "/failed",method = RequestMethod.GET)
    public Map<String,String> requestFailed(){
        Map<String,String> map = new HashMap<>();
        map.put("code","-1");
        map.put("msg","请求错误");
        return map;
    }
}
