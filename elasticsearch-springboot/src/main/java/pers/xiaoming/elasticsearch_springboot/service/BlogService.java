package pers.xiaoming.elasticsearch_springboot.service;

import pers.xiaoming.elasticsearch_springboot.model.Blog;

import java.util.List;

public interface BlogService {
    int createBlog(Blog blog);

    Blog getBlog(int id);

    Blog getBlogByTitle(String title);

    List<Blog> getBlogByAuthor(String author);
}
