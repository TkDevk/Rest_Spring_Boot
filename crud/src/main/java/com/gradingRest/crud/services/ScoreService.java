package com.gradingRest.crud.services;

import com.gradingRest.crud.models.ExamModel;
import com.gradingRest.crud.models.QuestionModel;
import com.gradingRest.crud.models.ScoreModel;
import com.gradingRest.crud.repositories.IExamRepository;
import com.gradingRest.crud.repositories.IScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;


@Service
public class ScoreService {
    @Autowired
    IScoreRepository scoreRepository;
    @Autowired
    IExamRepository examRepository;
    @Autowired
    QuestionService questionService;
    public boolean addQuestionToExam(Long examId, ScoreModel score) {
        Optional<ExamModel> optionalExam = examRepository.findById(examId);
        if (optionalExam.isPresent()) {
            ExamModel exam = optionalExam.get();
            // Set the relation between question and exam
            score.setExam(exam);
            // Save question in database
            scoreRepository.save(score);
            // Add question to exam
            exam.addScore(score);
            // Save the update version of the new exam
            examRepository.save(exam);
            return true;
        } else {
            return false;
        }
    }
    //Services providing the methods to controller so we can just decide what to do with them
    public ArrayList<ScoreModel> getScore(){
        return (ArrayList<ScoreModel>) scoreRepository.findAll();
    }
    public ScoreModel insertAnswer(ScoreModel score) {
        // Jpa.Repository provides the Save method
        return scoreRepository.save(score);
    }
}