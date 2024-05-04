package com.gradingRest.crud.services;

import com.gradingRest.crud.models.QuestionModel;
import com.gradingRest.crud.models.StudentModel;
import com.gradingRest.crud.repositories.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    IQuestionRepository questionRepository;

    public ArrayList<QuestionModel> getQuestions(){

        return (ArrayList<QuestionModel>) questionRepository.findAll();
    }

    public QuestionModel insertQuestion(QuestionModel question){

        //Jpa.Repository provides the Save method
        return questionRepository.save(question);
    }

    //Nullable option in order to avoid any error regarding if there is data or not
    public Optional<QuestionModel> getQuestionById(Long id){
        return questionRepository.findById(id);
    }
}
