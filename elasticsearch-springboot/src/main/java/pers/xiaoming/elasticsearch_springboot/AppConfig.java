package pers.xiaoming.elasticsearch_springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("pers.xiaoming.elasticsearch_springboot.dao")
public class AppConfig {
}
