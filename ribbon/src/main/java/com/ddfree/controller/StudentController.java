package com.ddfree.controller;

import com.ddfree.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
public class StudentController {
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForObject("http://provider/findAll",Collection.class);
    }

    @GetMapping("/index")
    public String index(){
        return restTemplate.getForObject("http://provider/index",String.class);
    }
}
