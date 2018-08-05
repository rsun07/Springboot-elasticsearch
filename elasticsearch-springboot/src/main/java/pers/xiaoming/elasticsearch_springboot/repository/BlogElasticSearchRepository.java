package pers.xiaoming.elasticsearch_springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import pers.xiaoming.elasticsearch_springboot.model.Blog;

public interface BlogElasticSearchRepository extends ElasticsearchRepository<Blog, String> {

    // spring will generate the function by the name
    Page<Blog> findDistinctBlogByAuthorContainingOrTitleContaining(String author, String title, Pageable pageable);
}
