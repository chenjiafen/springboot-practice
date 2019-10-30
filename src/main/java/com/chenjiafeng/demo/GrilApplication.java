package com.chenjiafeng.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class GrilApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrilApplication.class, args);
    }

}
