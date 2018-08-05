package pers.xiaoming.elasticsearch_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pers.xiaoming.elasticsearch_springboot.dao.IBlogDao;
import pers.xiaoming.elasticsearch_springboot.model.Blog;
import pers.xiaoming.elasticsearch_springboot.repository.BlogElasticSearchRepository;

import java.util.ArrayList;
import java.util.List;

@Service
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

        Pageable pageable = PageRequest.of(0, 20);
        Page<Blog> page = repository.findDistinctBlogByAuthorContainingOrTitleContaining(author, title, pageable);

        List<Blog> result = new ArrayList<>();
        page.forEach(result::add);

        return result;
    }
}
