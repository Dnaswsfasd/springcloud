package com.ddfree.controller;


import com.ddfree.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student>  findAll(){
        return restTemplate.getForEntity("http://localhost:8010/findAll",Collection.class).getBody();
    }

    @GetMapping("/findAll2")
    public Collection<Student>  findAll2(){
        return restTemplate.getForObject("http://localhost:8010/findAll", Collection.class);
    }

    @GetMapping("/findById/{id}")
    public Student  findById(@PathVariable("id") long id){
        return restTemplate.getForEntity("http://localhost:8010/findById/{id}",Student.class,id).getBody();
    }

    @GetMapping("/findById2/{id}")
    public Student findById2(@PathVariable("id") long id){
        return restTemplate.getForObject("http://localhost:8010/findById/{id}",Student.class,id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForEntity("http://localhost:8010/save",student,String.class).getBody();
    }

    @PostMapping("/save2")
    public void save2(Student student){
        restTemplate.postForObject("http://localhost:8010/save",student,String.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://localhost:8010/update",student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id){
        restTemplate.delete("http://localhost:8010/deleteById/{id}",id);
    }
}
