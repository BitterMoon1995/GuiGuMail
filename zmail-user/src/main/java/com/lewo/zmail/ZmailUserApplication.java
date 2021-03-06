package com.lewo.zmail;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = "com.lewo.zmail.user.com.lewo.zmail.manage.dao")//使用通用mapper的mapperScan
@SpringBootApplication
public class ZmailUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmailUserApplication.class, args);
    }

}
