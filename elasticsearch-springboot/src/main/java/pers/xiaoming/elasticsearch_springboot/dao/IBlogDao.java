package pers.xiaoming.elasticsearch_springboot.dao;

import org.springframework.stereotype.Repository;
import pers.xiaoming.elasticsearch_springboot.model.Blog;

import java.util.List;

@Repository
public interface IBlogDao {
    int insert(Blog blog);

    Blog selectById(int id);

    Blog selectByTitle(String title);

    List<Blog> selectByAuthor(String author);

    List<Blog> selectAll();
}
