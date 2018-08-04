package pers.xiaoming.elasticsearch_springboot.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.xiaoming.elasticsearch_springboot.exception.ResourceNotFoundException;
import pers.xiaoming.elasticsearch_springboot.model.MyBlog;
import pers.xiaoming.elasticsearch_springboot.service.BlogService;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogContoller {

    private BlogService service;

    @RequestMapping(method = RequestMethod.POST)
    public MyBlog post(MyBlog blog) {
        service.createBlog(blog);
        return blog;
    }

    @RequestMapping(method = RequestMethod.GET)
    public MyBlog get(@Param("id") int id) {
        MyBlog blog = service.getBlog(id);
        if (blog == null) {
            throw new ResourceNotFoundException();
        }
        return blog;
    }

    @RequestMapping(value = "/range", method = RequestMethod.GET)
    public List<MyBlog> getByRange(@Param("start") int start, @Param("end") int end) {
        return service.getBlogs(start, end);
    }
}
