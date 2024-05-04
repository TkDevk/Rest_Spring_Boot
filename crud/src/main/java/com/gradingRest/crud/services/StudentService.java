package com.gradingRest.crud.services;
import com.gradingRest.crud.models.StudentModel;
import com.gradingRest.crud.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {
    //Autowired allow dependencies injection
    @Autowired
    IStudentRepository studentRepository;
    //Jpa.Repository provides packages to make request and methods

    public ArrayList<StudentModel> getStudents(){

        return (ArrayList<StudentModel>) studentRepository.findAll();
    }

    public StudentModel insertStudent(StudentModel student){

        //Jpa.Repository provides the Save method
        return studentRepository.save(student);
    }

    //Nullable option in order to avoid any error regarding if there is data or not
    public Optional<StudentModel> getById(Long id){
        return studentRepository.findById(id);
    }


}
