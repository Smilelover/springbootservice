package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供者
 * Created by hsh on 2017/12/25.
 */
@RestController
public class HelloWord {


    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hi" , method = RequestMethod.POST)
    public String home(@RequestParam String name) throws InterruptedException {
        System.out.println("sssssssssssssssssssssssssss+==================");
        return "hi "+name+",i am from port:" +port;
    }

}
