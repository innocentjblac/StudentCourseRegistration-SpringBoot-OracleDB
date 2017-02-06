package com.priyam.spring;/**
 * Created by dni_tahniat on 24/1/2017.
 */

import com.priyam.spring.entity.Student;
import com.priyam.spring.repository.StudentRepo;
import com.priyam.spring.service.IStudentService;
import com.priyam.spring.service.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MockServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(MockServiceTest.class);

//    @Autowired
    private IStudentService studentService;
//    @Autowired



//    @MockBean
    private StudentRepo studentRepoMock;

    @Before
    public void setUp(){
        logger.info("Inside Before :: setUp() ..");
        studentRepoMock= mock(StudentRepo.class);
        studentService=new StudentServiceImpl(studentRepoMock);
        logger.info("Inside Before :: setUp() finished successfully..");

    }

    @Test
    public void testFindByID(){
        logger.info("Inside testFindByID  ..");
//        studentRepoMock= mock(StudentRepo.class);
//        studentService=new StudentServiceImpl(studentRepoMock);






        Student s1=new Student(1,"Ashraf","011");
        Student s2=new Student(2,"Billgates","012");
        Student s3=new Student(3,"Catstevens","013");


        List<Student> s2List=new ArrayList<Student>();
        s2List.add(s2);

//        Student x=s2List.get(0);
//        logger.info("x is : "+x.getId());

        when(studentRepoMock.save(s1)).thenReturn(s1);
        when(studentRepoMock.save(s2)).thenReturn(s2);
        when(studentRepoMock.save(s3)).thenReturn(s3);
        when(studentRepoMock.findById(2)).thenReturn(s2List);
//        when(studentRepoMock.findByName("Ashraf").get(0)).thenReturn(s1);


        logger.info("expected : "+s2List.get(0).getId()+" ; actual : "+studentService.findById(2).getId());
        assertEquals(s2List.get(0),studentService.findById(2));
//        assertEquals(s2,studentService.findByName("Ashraf").get(0));


//        when(studentRepoMock.findById(1)).thenReturn(null);
//        Student student_x=studentService.findById(1);
//        assertEquals(student_x,null);
        logger.info("Inside testFindByID :: finished successully..");

    }



}
