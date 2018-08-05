package pers.xiaoming.elasticsearch_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.xiaoming.elasticsearch_springboot.exception.ExceptionResolver;
import pers.xiaoming.elasticsearch_springboot.exception.ResourceNotFoundException;
import pers.xiaoming.elasticsearch_springboot.model.Blog;
import pers.xiaoming.elasticsearch_springboot.service.BlogService;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogContoller extends ExceptionResolver {

    @Autowired
    private BlogService service;

    @RequestMapping(method = RequestMethod.POST)
    public Blog post(@RequestBody Blog blog) {
        service.createBlog(blog);
        return blog;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Blog get(@Param("id") int id) {
        System.out.println(id);
        Blog blog = service.getBlog(id);
        if (blog == null) {
            throw new ResourceNotFoundException();
        }
        return blog;
    }

    @RequestMapping(value = "/range", method = RequestMethod.GET)
    public List<Blog> getByRange(@Param("start") int start, @Param("end") int end) {
        return service.getBlogs(start, end);
    }
}
