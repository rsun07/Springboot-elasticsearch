package pers.xiaoming.elasticsearch_springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import pers.xiaoming.elasticsearch_springboot.model.Blog;

import java.util.List;

public interface BlogESRepository extends ElasticsearchRepository<Blog, String> {

    Page<Blog> findByAuthor(String author, Pageable pageable);

    Page<Blog> findByAuthorNot(String author, Pageable pageable);

    List<Blog> findByContentContaining(String searchStr);

    List<Blog> findByContentContainingOrderByCreatedAtAsc(String searchStr);

    // spring will generate the function by the name
    Page<Blog> findDistinctBlogByAuthorContainingOrTitleContaining(String author, String title, Pageable pageable);
}
