package com.example.demo.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ctc.wstx.util.StringUtil;
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
@Cacheable
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    public Goods selectGoods(){
        Goods goods = goodsMapper.selectByPrimaryKey((long)1);
        redisTemplate.opsForValue().set("goods"+goods.getCategoryId(), JSON.toJSONString(goods));
        return goods;
    }


    public Goods selectGoodsV2(String name){
        Goods goods1 = null;
        // 查询redis缓存
        String goods = redisTemplate.opsForValue().get("goods" + name);
        if (goods == null){
            // 查数据库 sql
            goods1 = goodsMapper.selectByPrimaryKey((long)1);
            //查出来的数据存入redis
            redisTemplate.opsForValue().set("goods"+goods1.getName(), JSON.toJSONString(goods));
            return goods1;
        }
        // 缓存有数据，直接取出来
        try {
            goods1 = objectMapper.readValue(goods , new TypeReference<Goods>(){});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return goods1;
    }


}
