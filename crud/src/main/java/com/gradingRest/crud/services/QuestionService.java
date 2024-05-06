package com.gradingRest.crud.services;

import com.gradingRest.crud.models.ExamModel;
import com.gradingRest.crud.models.QuestionModel;
import com.gradingRest.crud.models.StudentModel;
import com.gradingRest.crud.repositories.IExamRepository;
import com.gradingRest.crud.repositories.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    IQuestionRepository questionRepository;

    @Autowired
    IExamRepository examRepository;

    //Set a boolean method in order to check if there is an Exam creted
    public boolean addQuestionToExam(Long examId, QuestionModel question) {
        Optional<ExamModel> optionalExam = examRepository.findById(examId);
        if (optionalExam.isPresent()) {
            ExamModel exam = optionalExam.get();
            // Set the relation between question and exam
            question.setExam(exam);
            // Save question in database
            questionRepository.save(question);
            // Add question to exam
            exam.addQuestion(question);
            // Save the update version of the new exam
            examRepository.save(exam);
            return true;
        } else {
            return false;
        }
    }

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
