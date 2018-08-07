package pers.xiaoming.springboot.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan

// could be replaced by @SpringBootConfiguration
// Already included in @SpringBootApplication
// @Configuration

public class HelloApplication {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world spring boot";
    }


    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }
}
