package com.example.feign.controller;
import com.example.feign.service.impl.HelloSerivceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过service定义的Feign客户端HelloService 来消费服务
 * Created by hsh on 2017/12/25.
 */
@RestController
public class HelloController {

    @Autowired
   private HelloSerivceImpl helloService;

    @RequestMapping(value = "/hi")
    public String sayHi(@RequestParam String name){
        return helloService.hello(name);
    }
}
