package pers.xiaoming.elasticsearch_springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @JsonProperty
    private int id;

    @JsonProperty
    private String author;

    @JsonProperty
    private String title;

    @JsonProperty
    private String content;

    @JsonProperty("created_at")
    private Date createdAt;
}
