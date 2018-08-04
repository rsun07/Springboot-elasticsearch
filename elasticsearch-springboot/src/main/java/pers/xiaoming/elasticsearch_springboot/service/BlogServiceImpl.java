package pers.xiaoming.elasticsearch_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.xiaoming.elasticsearch_springboot.dao.IBlogDao;
import pers.xiaoming.elasticsearch_springboot.model.Blog;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private IBlogDao blogDao;

    @Autowired
    public BlogServiceImpl(IBlogDao blogDao) {
        this.blogDao = blogDao;
    }

    @Override
    public int createBlog(Blog blog) {
        return blogDao.insert(blog);
    }

    @Override
    public Blog getBlog(int id) {
        return blogDao.select(id);
    }

    @Override
    public List<Blog> getBlogs(int start, int end) {
        return blogDao.selectByIdRange(start, end);
    }
}
