package pers.xiaoming.springboot.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.xiaoming.springboot.ssm.entity.Student;
import pers.xiaoming.springboot.ssm.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    private IStudentService service;

    @Autowired
    public StudentController(IStudentService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(Student student) {
        service.createStudent(student);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateStudent(Student student) {
        service.updateStudent(student);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
        Student student = service.getStudent(id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteStudent(@PathVariable("id") int id) {
        boolean del = service.deleteStudent(id);

        return new ResponseEntity<>(del, HttpStatus.OK);
    }
}
