package pers.xiaoming.elasticsearch_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
    public Blog getByTitle(@PathVariable("title") String title) {
        return nullCheck(service.getBlogByTitle(title));
    }

    @RequestMapping(value = "/author/{author}", method = RequestMethod.GET)
    public List<Blog> getByAuthor(@PathVariable("author") String author) {
        return service.getBlogByAuthor(author);
    }

    private Blog nullCheck(Blog blog) {
        if (blog == null) {
            throw new ResourceNotFoundException();
        }
        return blog;
    }
}
