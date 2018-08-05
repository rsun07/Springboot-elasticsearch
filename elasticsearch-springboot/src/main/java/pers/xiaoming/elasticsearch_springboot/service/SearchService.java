package pers.xiaoming.elasticsearch_springboot.service;

import pers.xiaoming.elasticsearch_springboot.model.Blog;

import java.util.List;

public interface SearchService {
    Blog searchTitle(String title);
}
