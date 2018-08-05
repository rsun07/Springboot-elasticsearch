package pers.xiaoming.elasticsearch_springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xiaoming.elasticsearch_springboot.model.Blog;
import pers.xiaoming.elasticsearch_springboot.repository.BlogESRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchServiceTest {

    @Autowired
    private BlogESRepository repository;

    @Test
    public void test() {
        Page<Blog> blogs = repository.findByAuthor("Ryan", PageRequest.of(0, 20));
        System.out.println(blogs.toString());

        List<Blog> blogList = new ArrayList<>();
        blogs.forEach(blogList::add);
        System.out.println(blogList);
    }
}
