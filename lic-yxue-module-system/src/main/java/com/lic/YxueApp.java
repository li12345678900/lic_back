package com.lic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 作者：lic
 * 创建时间：2020/9/22
 */

@SpringBootApplication
@MapperScan("com.lic.dao")
public class YxueApp {
    public static void main(String[] args) {
        SpringApplication.run(YxueApp.class,args);
    }
}
