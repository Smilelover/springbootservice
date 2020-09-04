package com.example.demo.Service;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Goods;
import com.example.demo.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: chenjianeng
 * @Date：2020/8/31 10:58
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    public Goods selectGoods(){
        Goods goods = goodsMapper.selectByPrimaryKey((long)1);
        redisTemplate.opsForValue().set("goods", JSON.toJSONString(goods));
        return goods;

    }
}
