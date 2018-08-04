package pers.xiaoming.elasticsearch_springboot.service;

import pers.xiaoming.elasticsearch_springboot.model.MyBlog;

import java.util.List;

public interface BlogService {
    int createBlog(MyBlog blog);

    MyBlog getBlog(int id);

    List<MyBlog> getBlogs(int start, int end);
}
