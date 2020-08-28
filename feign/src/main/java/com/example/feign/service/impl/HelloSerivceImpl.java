package com.example.feign.service.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: chenjianeng
 * @Date：2020/8/28 14:37
 */
@FeignClient(value = "demo")
public interface HelloSerivceImpl {

    @RequestMapping(value = "/hi", method = RequestMethod.POST)
    String hello(@RequestParam String name);
}
