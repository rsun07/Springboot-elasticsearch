package pers.xiaoming.springboot.jersey_jetty.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class Student {

    @JsonProperty
    @JsonSerialize(using = ToStringSerializer.class)
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    @JsonSerialize(using = ToStringSerializer.class)
    private double score;

    public Student() {
    }

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
