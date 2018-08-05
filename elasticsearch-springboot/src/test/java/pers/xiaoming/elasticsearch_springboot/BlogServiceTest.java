package pers.xiaoming.elasticsearch_springboot;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xiaoming.elasticsearch_springboot.model.Blog;
import pers.xiaoming.elasticsearch_springboot.service.BlogService;

// BUG:
// test directory not shares resources folder with the main dir
// After copy paste the resources dir, test get passed
// Before it cannot find mybatis_blog.xml

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceTest {
    @Autowired
    @Qualifier("blogService")
    private BlogService blogService;

    private static Blog blog;

    @BeforeClass
    public static void createStudent() {
        blog = new Blog("MyTitle " + System.currentTimeMillis(), "TestUser", "Random content");
    }

    @Test
    public void testCURD() {
        blogService.createBlog(blog);
        String title = blog.getTitle();

        Blog actual = blogService.getBlogByTitle(title);
        Assert.assertTrue(blog.equals(actual));
    }
}
