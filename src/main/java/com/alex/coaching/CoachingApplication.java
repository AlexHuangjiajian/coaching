package com.alex.coaching;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.alex.coaching.mapper")
public class CoachingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoachingApplication.class, args);
    }

}
