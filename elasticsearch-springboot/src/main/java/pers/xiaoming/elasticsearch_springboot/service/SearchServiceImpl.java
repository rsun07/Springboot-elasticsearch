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
import java.util.Optional;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private BlogElasticSearchRepository repository;

    @Autowired
    private IBlogDao blogDao;

    @Override
    public Blog searchTitle(String title) {
        List<Blog> blogs = blogDao.selectAll();
        repository.deleteAll();
        repository.saveAll(blogs);

        Pageable pageable = PageRequest.of(0, 20);
        Optional<Blog> result = repository.findById(title);

        return result.get();
    }
}
