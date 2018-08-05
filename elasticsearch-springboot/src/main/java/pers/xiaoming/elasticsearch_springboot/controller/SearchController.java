package pers.xiaoming.elasticsearch_springboot.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.xiaoming.elasticsearch_springboot.exception.BadRequestException;
import pers.xiaoming.elasticsearch_springboot.exception.ExceptionResolver;
import pers.xiaoming.elasticsearch_springboot.model.Blog;
import pers.xiaoming.elasticsearch_springboot.service.SearchService;

import java.util.List;

@RestController
@RequestMapping("/blog_search")
public class SearchController extends ExceptionResolver {

    @Autowired
    private SearchService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Blog> search(@RequestBody Blog blog) throws BadRequestException {
        if (blog == null ||
                (StringUtils.isBlank(blog.getAuthor())
                        && StringUtils.isBlank(blog.getTitle()))
            ) {
            throw new BadRequestException();
        }
        return service.search(blog.getAuthor(), blog.getTitle());
    }
}
