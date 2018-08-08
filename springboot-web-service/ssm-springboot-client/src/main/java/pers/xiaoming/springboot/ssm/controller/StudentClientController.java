package pers.xiaoming.springboot.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pers.xiaoming.springboot.ssm.entity.Student;

@RestController
@RequestMapping("/student")
public class StudentClientController {

    // in prod, it should load from config files for diff env
    private static final String SERVICE_ENDPOINT = "http://localhost:9090";
    private static final String SERVICE_PATH = "/student";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping
    @PostMapping
    public Student create(Student student) {
        return restTemplate.postForObject(SERVICE_ENDPOINT + SERVICE_PATH, student, Student.class);
    }

    @RequestMapping
    @GetMapping
    public Student get(@PathVariable("id") int id) {
        return restTemplate.getForObject(SERVICE_ENDPOINT + SERVICE_PATH, Student.class);
    }

}
