package com.example.demo.controller;

import com.example.demo.Service.GoodsService;
import com.example.demo.comm.JsonOut;
import com.example.demo.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chenjianeng
 * @Date：2020/8/31 10:57
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/insert")
    public JsonOut<Goods> insert(){
        JsonOut out = new JsonOut(200,"成功");
        out.setData(goodsService.selectGoods());
        return out;
    }

    @PostMapping("/select")
    public JsonOut<Goods> selectGoods(){
        JsonOut out = new JsonOut(200,"成功");
        out.setData(goodsService.selectGoodsV2("goods"));
        return out;
    }
}
