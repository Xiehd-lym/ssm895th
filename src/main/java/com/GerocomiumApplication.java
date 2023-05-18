package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dao")
public class GerocomiumApplication {// http://localhost:8080/ssm895th/admin/dist/index.html#/login 护工工号1

    public static void main(String[] args) {
        SpringApplication.run(GerocomiumApplication.class,args);
    }

}
