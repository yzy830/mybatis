package com.gerald.mybatis;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.gerald.mybatis.dao.modify.GoodsMapper;
import com.gerald.mybatis.pojo.Goods;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        
        GoodsMapper goodsMapper = context.getBean(GoodsMapper.class);
        
        Goods goods1 = new Goods();
        goods1.setGoodsName("123");
        goods1.setPrice(13);
        
        Goods goods2 = new Goods();
        goods2.setGoodsName("456");
        goods2.setPrice(null);
        
        goodsMapper.batchInsert(goods1, goods2);
        
        System.out.println("id = " + goods1.getId());
        System.out.println("id = " + goods2.getId());
    }
}
