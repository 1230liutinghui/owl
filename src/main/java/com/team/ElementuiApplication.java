package com.team;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.team.dao"})
public class ElementuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElementuiApplication.class, args);
    }

}
