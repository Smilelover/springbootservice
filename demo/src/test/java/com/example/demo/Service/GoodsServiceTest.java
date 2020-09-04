package com.example.demo.Service;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Goods;
import com.example.demo.mapper.GoodsMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.security.RunAs;

import org.junit.jupiter.api.Assertions.*;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: chenjianeng
 * @Date：2020/9/4 14:33
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class GoodsServiceTest {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void test(){
        Goods goods = goodsMapper.selectByPrimaryKey((long)1);
        redisTemplate.opsForValue().set("goods", JSON.toJSONString(goods));
    }
}