package com.example.demo.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Goods;
import com.example.demo.mapper.GoodsMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    private ObjectMapper objectMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Cacheable(key = "goods",value = "good")
    public Goods selectGoods(){
        Goods goods = goodsMapper.selectByPrimaryKey((long)1);
       // redisTemplate.opsForValue().set("goods", JSON.toJSONString(goods));
        return goods;
    }

    @Cacheable(key = "goods",value = "good")
    public Goods selectGoodsV2(String name){
        String goods = redisTemplate.opsForValue().get(name);
        Goods goods1 = null;
        try {
            goods1 = objectMapper.readValue(goods , new TypeReference<Goods>(){});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return goods1;
    }


}
