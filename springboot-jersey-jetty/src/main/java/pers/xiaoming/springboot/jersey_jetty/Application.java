package pers.xiaoming.springboot.jersey_jetty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

// @Configuration
// @ComponentScan("pers.xiaoming.springboot.ssm")
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@MapperScan("pers.xiaoming.springboot.jersey_jetty.dao")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
