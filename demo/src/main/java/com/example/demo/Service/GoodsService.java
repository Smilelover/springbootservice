package com.example.demo.Service;

import com.example.demo.entity.Goods;
import com.example.demo.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: chenjianeng
 * @Date：2020/8/31 10:58
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public Goods selectGoods(){
        return goodsMapper.selectByPrimaryKey((long) 1);
    }
}
