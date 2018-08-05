package pers.xiaoming.elasticsearch_springboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pers.xiaoming.elasticsearch_springboot.dao.IBlogDao;
import pers.xiaoming.elasticsearch_springboot.model.Blog;
import pers.xiaoming.elasticsearch_springboot.repository.BlogESRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SearchServiceImpl implements SearchService {

    private static final int DEFAULT_MAX_PAGE_SIZE = 20;

    private BlogESRepository repository;

    private IBlogDao blogDao;

    public SearchServiceImpl(BlogESRepository repository, IBlogDao blogDao) {
        this.repository = repository;
        this.blogDao = blogDao;
    }

    @Override
    public Blog searchByTitle(String title) {
        List<Blog> blogs = blogDao.selectAll();
        repository.deleteAll();
        repository.saveAll(blogs);

        Optional<Blog> result = repository.findById(title);

        return result.orElse(null);
    }

    @Override
    public List<Blog> searchByAuthor(String author) {
        Page<Blog> result =  searchByAuthor(author, PageRequest.of(0, DEFAULT_MAX_PAGE_SIZE));
        return result.getContent();
    }


    @Override
    public Page<Blog> searchByAuthor(String author, PageRequest page) {
        List<Blog> blogs = blogDao.selectAll();
        repository.deleteAll();
        repository.saveAll(blogs);

        return repository.findByAuthor(author, page);
    }
}
