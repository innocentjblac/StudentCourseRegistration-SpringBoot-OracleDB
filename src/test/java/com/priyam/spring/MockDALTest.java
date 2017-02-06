package com.priyam.spring;

import com.priyam.spring.entity.Student;
import com.priyam.spring.repository.StudentRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockDALTest {

    //REPOSITORY TEST ...

    static final Logger logger = LoggerFactory.getLogger(MockDALTest.class);


    @Autowired
    private StudentRepo studentRepo;



    @Test
    public void findAll() {


        Iterable<Student> students = studentRepo.findAll();

        assertTrue(students != null);
//        assertTrue(size!=0);


    }

    @Test
    public void findById() {


        int iter = 0;
        int match = 0;
        Iterable<Student> students = studentRepo.findAll();
        Student firstStudent = null;
        if (students != null) {
            for (Student student : students) {
                if (iter == 0) {
                    firstStudent = student;
                    match++;
                } else {
                    if (student.getId()==firstStudent.getId()) {
                        match++;
                    }
                }
                iter++;
            }
            if (iter != 0) {
//                Student firstStudent=students.iterator().next();

                if (firstStudent != null) {
//                    logger.info("findById :: 1st student name : " + firstStudent.getName() + " ; phone : " + firstStudent.getPhone());
                    int findByNameSizeDB = studentRepo.findById(firstStudent.getId()).size();
//                    logger.info("findById :: newStudent student name : " + firstStudent.getName() + " ; phone : " + firstStudent.getPhone());
//
//                    assertEquals(firstStudent.getId(), newStudent.getId());
//                    assertEquals(firstStudent.getName(), newStudent.getName());
                    assertEquals(match,findByNameSizeDB);
                } else {
                    assertTrue(false);

                }

            } else {
                logger.info("findById :: student list size 0");
            }
        }

    }

    @Test
    public void findbyName() {

        int iter = 0;
        int match = 1;
        Iterable<Student> students = studentRepo.findAll();
        Student firstStudent = null;
        if (students != null) {
            for (Student student : students) {
                if (iter == 0) {
                    firstStudent = student;
                } else {
                    if (student.getName().compareTo(firstStudent.getName()) == 0) {
                        match++;
                    }
                }
                iter++;
            }
            if (iter != 0) {
//                Student firstStudent=students.iterator().next();

                if (firstStudent != null) {
//                    logger.info("findById :: 1st student name : " + firstStudent.getName() + " ; phone : " + firstStudent.getPhone());
                    int findByNameSizeDB = studentRepo.findByName(firstStudent.getName()).size();
//                    logger.info("findById :: newStudent student name : " + firstStudent.getName() + " ; phone : " + firstStudent.getPhone());
//
//                    assertEquals(firstStudent.getId(), newStudent.getId());
//                    assertEquals(firstStudent.getName(), newStudent.getName());
                    assertEquals(match,findByNameSizeDB);
                } else {
                    assertTrue(false);

                }

            } else {
                logger.info("findById :: student list size 0");
            }
        }
    }

}
