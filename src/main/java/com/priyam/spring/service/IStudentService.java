package com.priyam.spring.service;/**
 * Created by dni_tahniat on 23/1/2017.
 */

import com.priyam.spring.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public interface IStudentService {

    static final Logger logger = LoggerFactory.getLogger(IStudentService.class);

    public List<Student> findAll();

    public Student findById(int id);

    public List<Student> findByName(String name);

    public List<Student> findByNameLike (String name);

    public void removeStudent(int id);

    public Student addStudent(Student customer);

    public void editStudent(Student customer);

    public List<Student> findStudentsWithEvenID();
}
