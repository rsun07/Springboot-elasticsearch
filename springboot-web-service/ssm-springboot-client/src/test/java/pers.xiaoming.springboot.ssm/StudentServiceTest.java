package pers.xiaoming.springboot.ssm;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.xiaoming.springboot.ssm.entity.Student;
import pers.xiaoming.springboot.ssm.service.IStudentService;

// Sometimes, test may not share resources folder with the main dir
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private IStudentService service;

    private static Student student;

    @BeforeClass
    public static void createStudent() {
        student = new Student("Mike", 98.5);
    }

    @Test
    public void testCURD() {
        service.createStudent(student);
        int id = student.getId();
        testGet(student, id);

        student.setScore(99);
        service.updateStudent(student);
        testGet(student, id);

        service.deleteStudent(id);
        testGet(null, id);
    }

    private void testGet(Student expect, int id) {
        Student actual = service.getStudent(id);
        Assert.assertEquals(expect, actual);
    }
}
