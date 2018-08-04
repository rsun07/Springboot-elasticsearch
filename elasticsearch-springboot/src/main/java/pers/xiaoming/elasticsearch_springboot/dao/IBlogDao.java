package pers.xiaoming.elasticsearch_springboot.dao;

import org.springframework.stereotype.Repository;
import pers.xiaoming.elasticsearch_springboot.model.MyBlog;

import java.util.List;

@Repository
public interface IBlogDao {
    int insert(MyBlog blog);

    MyBlog select(int id);

    List<MyBlog> selectByIdRange(int start, int end);
}
