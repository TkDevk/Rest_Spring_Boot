package com.gradingRest.crud.services;
import com.gradingRest.crud.models.ExamModel;
import com.gradingRest.crud.repositories.IExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ExamService {
    //Brings the connection instead of a connection String
    @Autowired
    IExamRepository examRepository;
    public ArrayList<ExamModel> getExams(){

        return (ArrayList<ExamModel>) examRepository.findAll();
    }

    public ExamModel insertExam(ExamModel exam){

        //Jpa.Repository provides the Save method
        return examRepository.save(exam);
    }

    //Nullable option in order to avoid any error regarding if there is data or not
    public Optional<ExamModel> getExamById(Long id){
        return examRepository.findById(id);
    }

}
