package com.gerald.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.gerald.mybatis.service.BlogService;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        
        BlogService blogService = context.getBean(BlogService.class);
        
        blogService.mixLock1();
        System.out.println("unlock");
        blogService.mixLock2();
        System.out.println("unlock");
    }
}
