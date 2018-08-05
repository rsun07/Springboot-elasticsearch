package pers.xiaoming.elasticsearch_springboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import pers.xiaoming.elasticsearch_springboot.model.Blog;

import java.util.List;

public interface SearchService {
    Blog searchByTitle(String title);

    List<Blog> searchByAuthor(String author);

    Page<Blog> searchByAuthor(String author, PageRequest page);
}
