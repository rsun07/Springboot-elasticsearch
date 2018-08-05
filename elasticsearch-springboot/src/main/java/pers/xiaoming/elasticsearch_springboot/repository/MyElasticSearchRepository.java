package pers.xiaoming.elasticsearch_springboot.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import pers.xiaoming.elasticsearch_springboot.model.Blog;

public interface MyElasticSearchRepository extends ElasticsearchRepository<Blog, Integer> {
}
