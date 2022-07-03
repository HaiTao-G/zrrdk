package com.dibole.wxapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Tao
 * @version 1.0.0
 * @className WxappApplication.java
 * @description 启动类
 * @createTime 2020年12月04日 15:44:00
 */
@SpringBootApplication(scanBasePackages = "com.dibole")
@MapperScan("com.dibole.dao.mysql.zrrdk")
public class WxappApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxappApplication.class, args);
    }
}
