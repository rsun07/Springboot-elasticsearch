package pers.xiaoming.elasticsearch_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.xiaoming.elasticsearch_springboot.dao.IBlogDao;
import pers.xiaoming.elasticsearch_springboot.model.Blog;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private IBlogDao blogDao;

    @Override
    public int createBlog(Blog blog) {
        return blogDao.create(blog);
    }

    @Override
    public Blog getBlogByTitle(String title) {
        return blogDao.selectByTitle(title);
    }

    @Override
    public List<Blog> getBlogByAuthor(String author) {
        return blogDao.selectByAuthor(author);
    }


}
