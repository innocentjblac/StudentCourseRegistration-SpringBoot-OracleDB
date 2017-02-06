package com.priyam.spring.controller;/**
 * Created by dni_tahniat on 23/1/2017.
 */

import com.priyam.spring.entity.Student;
import com.priyam.spring.service.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/StudentApp")
public class StudentController extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }
//    private static final Logger logger = LoggerFactory.getLogger(MainController.class);


//    @Autowired
//    StudentRepo studentRepo;

//    @Autowired
    private IStudentService studentService;

    public IStudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

//    private List<StudentDTO> studentDTOList = null;

    public StudentController(IStudentService studentService){
    this.studentService=studentService;
    }

    @GetMapping("/student")
    public String showInitPage(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("evenStudents",studentService.findStudentsWithEvenID());
        return "student";

    }

    @PostMapping("/create")
    public String createStudent(@Valid Student student,BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
//            model.addAttribute("student", new Student());
            model.addAttribute("students", studentService.findAll());
            model.addAttribute("evenStudents",studentService.findStudentsWithEvenID());

            return "student";
        }

        studentService.addStudent(student);

        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("evenStudents",studentService.findStudentsWithEvenID());


        return "student";


    }

    @GetMapping("/delete")
    public String deleteStudentGET(@RequestParam(value="id") int studentID,Model model){

        studentService.removeStudent(studentID);

//        model.addAttribute("delete_success","success");
        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("evenStudents",studentService.findStudentsWithEvenID());

        return "student";
//        studentRepo.delete(id);
    }

    @PostMapping("/delete")
    public String deleteStudentPOST(@RequestParam(value = "delete_id") int studentID,Model model){

        logger.info("Student id to deleted : "+studentID);
        studentService.removeStudent(studentID);

        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("evenStudents",studentService.findStudentsWithEvenID());

        return "student";

    }


    // A demo comment
    @PostMapping("/showEdit")
    public String showEditPage(@RequestParam(value = "edit_id") int studentID,Model model){

        Student student=studentService.findById(studentID);
        model.addAttribute("student",student);

//        model.addAttribute("id",studentID);
//        model.addAttribute("name",student.getName());
//        model.addAttribute("phone",student.getPhone());

        return "edit";
    }

//    @PostMapping("/edit")
//    public String editStudentInfo(@RequestParam(value = "student_id",required = true) int studentID,@RequestParam(value = "student_name",required = true) String name,@RequestParam(value = "student_phone",required = true) String phone,Model model){
//        logger.info("Student id to edit : "+studentID+"; new name : "+name+" ; new phone : "+phone);
//
//        Student student=studentService.findById(studentID);
//        student.setName(name);
//        student.setPhone(phone);
//        studentService.editStudent(student);
//        logger.info("Student info edited successfully. ID : "+studentID);
//
//        model.addAttribute("student", new Student());
//        model.addAttribute("students", studentService.findAll());
//        return "student";
//
//
//
//    }

    @PostMapping("/edit")
    public String editStudentInfo(@Valid Student student,BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            logger.error("ERROR !");
//            model.addAttribute("student", new Student());
//            model.addAttribute("students", studentService.findAll());
//            return "student";
            return "edit";

        }

        logger.info("Student id to edit : "+student.getId()+"; new name : "+student.getName()+" ; new phone : "+student.getPhone());

        Student orig_student=studentService.findById(student.getId());
        orig_student.setName(student.getName());
        orig_student.setPhone(student.getPhone());
        studentService.editStudent(orig_student);
        logger.info("Student info edited successfully. ID : "+orig_student.getId());

        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("evenStudents",studentService.findStudentsWithEvenID());

        return "student";

    }


}
