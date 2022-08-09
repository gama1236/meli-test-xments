package com.prueba.melitest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class MelitestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MelitestApplication.class, args);
    }

}
