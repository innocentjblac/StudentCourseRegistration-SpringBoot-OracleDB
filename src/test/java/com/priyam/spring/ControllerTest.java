package com.priyam.spring;/**
 * Created by dni_tahniat on 29/1/2017.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.priyam.spring.entity.Student;
import com.priyam.spring.service.IStudentService;
import com.priyam.spring.service.StudentServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(ControllerTest.class);

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentServiceImpl studentService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testCreateClient() {
//
        try {
            Student s0 = new Student("Ashraf", "011");

            Student s1 = new Student(1, "Ashraf", "011");
            Student s2 = new Student(2, "Billgates", "012");
            Student s3 = new Student(3, "Catstevens", "013");

            List<Student> studentList = new ArrayList<Student>();

            given(studentService.addStudent(s0)).willReturn(s1);

            mockMvc.perform(post("/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsBytes(s0)))
                    .andExpect(status().isCreated());

        }catch(Exception e){
            logger.error(e.toString(),e);
        }



    }
}
