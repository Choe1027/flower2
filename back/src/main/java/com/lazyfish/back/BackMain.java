package com.lazyfish.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.lazyfish.service.repository")
@ComponentScan(basePackages = "com.lazyfish")
@EntityScan("com.lazyfish.core.pojo")
public class BackMain {

    public static void main(String[] args) {
        SpringApplication.run(BackMain.class, args);
    }
}
