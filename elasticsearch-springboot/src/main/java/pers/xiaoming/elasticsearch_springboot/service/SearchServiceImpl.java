package pers.xiaoming.elasticsearch_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import pers.xiaoming.elasticsearch_springboot.dao.IBlogDao;
import pers.xiaoming.elasticsearch_springboot.model.Blog;
import pers.xiaoming.elasticsearch_springboot.repository.BlogElasticSearchRepository;

import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {

    @Autowired
    private BlogElasticSearchRepository repository;

    @Autowired
    private IBlogDao blogDao;

    @Override
    public List<Blog> search(String author, String title) {
        List<Blog> blogs = blogDao.selectAll();
        repository.deleteAll();
        repository.saveAll(blogs);

        Page<Blog> page = repository.findDistinctBlogByAuthorContainingOrTitleContaining(author, title);

        List<Blog> result = new ArrayList<>();
        page.forEach(result::add);

        return result;
    }
}
