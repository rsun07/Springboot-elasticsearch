package pers.xiaoming.springboot.ssm.dao;

import org.springframework.stereotype.Repository;
import pers.xiaoming.springboot.ssm.entity.Student;

@Repository("IStudentDao")
public interface IStudentDao {
    int create(Student student);

    void update(Student student);

    Student get(int id);

    void delete(int id);
}
