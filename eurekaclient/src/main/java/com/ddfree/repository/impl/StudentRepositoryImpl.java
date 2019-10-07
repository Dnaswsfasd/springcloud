package com.ddfree.repository.impl;

import com.ddfree.Student;
import com.ddfree.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private static Map<Long,Student> map;
    static{
        map=new HashMap<>();
        map.put(1L,new Student(1L,"aa",22));
        map.put(2L,new Student(2L,"bb",23));
        map.put(3L,new Student(3L,"cc",24));
    }
    @Override
    public Collection<Student> findAll() {
        return map.values();
    }

    @Override
    public Student findById(long id) {
        return map.get(id);
    }

    @Override
    public void saveOrUpdate(Student student) {
        map.put(student.getId(),student);
    }

    @Override
    public void deleteById(long id) {
        map.remove(id);
    }


}
