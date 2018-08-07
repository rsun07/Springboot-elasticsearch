package pers.xiaoming.springboot.jersey_jetty.dao;

import org.springframework.stereotype.Repository;
import pers.xiaoming.springboot.jersey_jetty.entity.Student;

@Repository("IStudentDao")
public interface IStudentDao {
    int create(Student student);

    void update(Student student);

    Student get(int id);

    void delete(int id);
}
