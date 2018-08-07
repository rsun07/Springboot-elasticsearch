package pers.xiaoming.elasticsearch_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.xiaoming.elasticsearch_springboot.exception.BadRequestException;
import pers.xiaoming.elasticsearch_springboot.exception.ExceptionResolver;
import pers.xiaoming.elasticsearch_springboot.model.Blog;
import pers.xiaoming.elasticsearch_springboot.service.SearchService;

@RestController
@RequestMapping("/blog_search")
public class SearchController extends ExceptionResolver {

    private SearchService service;

    @Autowired
    public SearchController(SearchService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Blog searchByTitle(@Param("title") String title) throws BadRequestException {
        if (isBlank(title)) {
            throw new BadRequestException();
        }
        return service.searchByTitle(title);
    }

    boolean isBlank(String str) {
        if (str == null) {
            return true;
        }

        if (str.trim().toCharArray().length == 0) {
            return true;
        }

        return false;
    }
}
