package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.springboot.**.dao")
@SpringBootApplication
public class StudyApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }
    
}
