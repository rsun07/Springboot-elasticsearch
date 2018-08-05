package pers.xiaoming.elasticsearch_springboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import pers.xiaoming.elasticsearch_springboot.model.Blog;

import java.util.List;

public interface SearchService {
    void refreshRepository();

    Blog searchByTitle(String title);

    List<Blog> searchByAuthor(String author);

    Page<Blog> searchByAuthor(String author, PageRequest page);

    List<Blog> searchByContent(String author);

    List<Blog> searchByContent(String author, Sort sort);
}
