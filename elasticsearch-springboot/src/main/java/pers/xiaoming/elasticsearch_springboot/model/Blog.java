package pers.xiaoming.elasticsearch_springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(indexName = "blog", type = "blog")
public class Blog {

    // id annotation is for elastic search finding the primary key
    @Id
    @JsonProperty
    private String title;

    @JsonProperty
    private String author;

    @JsonProperty
    private String content;

    @JsonProperty("created_at")
    private Timestamp createdAt;
}
