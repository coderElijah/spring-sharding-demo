package com.elijah.springshardingdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringShardingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringShardingDemoApplication.class, args);
    }

}
