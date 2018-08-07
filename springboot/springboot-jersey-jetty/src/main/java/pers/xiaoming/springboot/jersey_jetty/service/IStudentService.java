package pers.xiaoming.springboot.jersey_jetty.service;


import pers.xiaoming.springboot.jersey_jetty.entity.Student;

public interface IStudentService {
    Student createStudent(Student student);

    void updateStudent(Student student);

    Student getStudent(int id);

    boolean deleteStudent(int id);
}
