package com.gradingRest.crud.controllers;

import com.gradingRest.crud.models.StudentModel;
import com.gradingRest.crud.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
//Allow methods and connection from my Front
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/student")
public class StudentController {
    //bring the methods that allow getStudents, insertStudent and getStudentById to check the exams related to each one
    @Autowired
    private StudentService studentService;
    //Jpa.Repository Method
    @GetMapping
    public ArrayList<StudentModel> getStudents(){
        //provide helpful methods
        return this.studentService.getStudents();
    }

    //Insert student method being called by model from controller
    @PostMapping
    public StudentModel insertStudent(@RequestBody StudentModel student){
        return this.studentService.insertStudent(student);
    }
    @GetMapping(path = "/{id}")
    public Optional<StudentModel> getStudentById(@PathVariable("id") Long id){
         return this.studentService.getById(id);
    }
}

