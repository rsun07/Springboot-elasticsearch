package pers.xiaoming.elasticsearch_springboot;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xiaoming.elasticsearch_springboot.model.Blog;
import pers.xiaoming.elasticsearch_springboot.service.BlogService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceTest {
    @Autowired
    private BlogService service;

    private static Blog blog;

    @BeforeClass
    public static void createStudent() {
        blog = new Blog("MyTitle", "AuthorMe", "Random content");
    }
}
