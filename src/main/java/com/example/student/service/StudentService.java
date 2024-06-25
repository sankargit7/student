package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private studentRepository repository;

    public Student saveStudent(Student student){
       return repository.save(student);
       
    }
    public List<Student> saveStudents(List<Student> students){
        return repository.saveAll(students);
    }
    public List<Student> getStudents(){
        return repository.findAll();
    }
    public Student getStudentsBYID(int id){
        return repository.findById(id).orElse(null);
    }
    public String deletStudent(int id){
        repository.deleteById(id);
        return "record deleted"+id;
    }
    public Student updateStudent(Student student){
        Student existingStudent =repository.findById(student.getId()).orElse(null);
        existingStudent.setId(student.getId());
        existingStudent.setName(student.getName());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setMarks(student.getMarks());
        return repository.save(existingStudent);
    }
    
    public Student getByName(String name) {
    	return repository.findByName(name);
    	
    }
    public List<Student> findByMarks(int marks) throws Exception {
        if(repository.findByMarks(marks).isEmpty()){
            throw new Exception("marks not found");
        }
        else {
            return repository.findByMarks(marks);
        }
    }
}
