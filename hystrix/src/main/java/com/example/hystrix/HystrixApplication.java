package com.example.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @EnableCircuitBreaker - 开启断路器。就是开启hystrix服务容错能力。
 * 当应用启用Hystrix服务容错的时候，必须增加的一个注解。
 */
@EnableHystrix
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }

}
