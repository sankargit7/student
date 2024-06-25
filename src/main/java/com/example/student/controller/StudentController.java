package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/addstudent")
    public Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }
    @PostMapping("/addstudents")
    public List<Student> addStudents(@RequestBody List<Student> students){
        return service.saveStudents(students);
    }

    @GetMapping("/Students")
    public List<Student> findAllStydents(){
        return service.getStudents();
    }

    @GetMapping("/Student/{id}")
    public Student findById(@PathVariable int id){
        return service.getStudentsBYID(id);
    }
    @DeleteMapping("delete/{id}")
    public String deletStudent(@PathVariable int id){
        return service.deletStudent(id);
    }
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return service.updateStudent(student);
    }
    @GetMapping("students/{marks}")
    public List<Student> getByMarks(@PathVariable int marks)  {

        return service.findByMarks(marks);
    }

}
