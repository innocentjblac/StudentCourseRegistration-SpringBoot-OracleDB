package com.priyam.spring.service;/**
 * Created by dni_tahniat on 23/1/2017.
 */

import com.priyam.spring.entity.Student;
import com.priyam.spring.repository.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Transactional
@Service
public class StudentServiceImpl implements IStudentService{

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);



    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> findAll() {
        List<Student> Studentlist=new ArrayList<>();
        Iterator<Student> iterator=studentRepo.findAll().iterator();
        while(iterator.hasNext()){
            Studentlist.add(iterator.next());
        }
        return Studentlist;
    }

    @Override
    public Student findById(int id) {
        return studentRepo.findById(id).get(0);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepo.findByName(name);
    }

    @Override
    public List<Student> findByNameLike(String name) {
        return studentRepo.findByNameLike(name);
    }

    @Override
    public void removeStudent(int id) {
        studentRepo.delete(id);
    }

    @Override
    public Student addStudent(Student student) {
        if(student!=null) {
            studentRepo.save(student);
        }else{
            logger.error("Student data cannot be null.");
        }

        return student;
    }

    @Override
    public void editStudent(Student Student) {
        Student c=findById(Student.getId());
        if(c!=null) {
            studentRepo.save(Student);
        }else{
            logger.error("Student data doesn't exist");
        }
    }

    @Override
    public List<Student> findStudentsWithEvenID() {
        return studentRepo.findStudentsWithEvenID();
    }
}
