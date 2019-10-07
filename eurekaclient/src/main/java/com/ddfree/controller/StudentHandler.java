package com.ddfree.controller;

import com.ddfree.Student;
import com.ddfree.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class StudentHandler {

    @Autowired
    private StudentRepository studentRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return studentRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student student(@PathVariable("id") long id){
        return studentRepository.findById(id);
    }

    @PostMapping("/save")
    //不加是requestBody接收前端传来的参数
    public void save(Student student){
        studentRepository.saveOrUpdate(student);
    }

    @PutMapping("/update")
    //@requestBody 接收前端传过来的jsonshu数据
    public void update(@RequestBody Student student){
        studentRepository.saveOrUpdate(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        studentRepository.deleteById(id);
    }

    @RequestMapping("/index")
    public String index(){
        return "当前端口"+this.port;
    }
}
