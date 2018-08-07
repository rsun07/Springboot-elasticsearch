package pers.xiaoming.springboot.jersey_jetty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.xiaoming.springboot.jersey_jetty.dao.IStudentDao;
import pers.xiaoming.springboot.jersey_jetty.entity.Student;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {
    private IStudentDao dao;

    @Autowired
    public StudentServiceImpl(IStudentDao dao) {
        this.dao = dao;
    }

    public Student createStudent(Student student) {
        int id = dao.create(student);
        return student;
    }

    public void updateStudent(Student student) {
        dao.update(student);
    }

    public Student getStudent(int id) {
        return dao.get(id);
    }

    public boolean deleteStudent(int id) {
        dao.delete(id);
        return true;
    }
}
