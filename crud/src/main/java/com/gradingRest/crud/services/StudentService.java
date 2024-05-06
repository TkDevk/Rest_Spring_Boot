package com.gradingRest.crud.services;
import com.gradingRest.crud.models.ExamModel;
import com.gradingRest.crud.models.StudentModel;
import com.gradingRest.crud.repositories.IExamRepository;
import com.gradingRest.crud.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    //Autowired allow dependencies injection
    @Autowired
    IStudentRepository studentRepository;
    @Autowired
    IExamRepository examRepository;

    public StudentService(IStudentRepository studentRepository, IExamRepository examRepository) {
    }

    //Jpa.Repository provides packages to make request and methods
    public void assignExamToAllStudents(ExamModel exam) {
        List<StudentModel> students = studentRepository.findAll();
        for (StudentModel student : students) {
            exam.setStudent(student);
            student.getExams().add(exam);
            //Save each for each student
            examRepository.save(exam);
        }
    }
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
