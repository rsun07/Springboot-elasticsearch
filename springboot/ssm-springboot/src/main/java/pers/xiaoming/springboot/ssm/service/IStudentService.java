package pers.xiaoming.springboot.ssm.service;


import pers.xiaoming.springboot.ssm.entity.Student;

public interface IStudentService {
    Student createStudent(Student student);

    void updateStudent(Student student);

    Student getStudent(int id);

    boolean deleteStudent(int id);
}
