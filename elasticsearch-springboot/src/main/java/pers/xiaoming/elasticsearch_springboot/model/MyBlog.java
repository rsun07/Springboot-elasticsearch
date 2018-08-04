package pers.xiaoming.elasticsearch_springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyBlog {
    private int id;
    private String author;
    private String title;
    private String content;
    private Date createdAt;
}
