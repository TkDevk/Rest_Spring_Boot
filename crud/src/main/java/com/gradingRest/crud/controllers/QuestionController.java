package com.gradingRest.crud.controllers;
import com.gradingRest.crud.models.QuestionModel;
import com.gradingRest.crud.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/exam/{examId}/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    //Jpa.Repository Method
    @GetMapping
    public ArrayList<QuestionModel> getQuestions(){
        //provide helpful methods
        return this.questionService.getQuestions();
    }
    @PostMapping
    public QuestionModel insertQuestion(@RequestBody QuestionModel question){
        return this.questionService.insertQuestion(question);
    }
    @GetMapping(path = "/{id}")
    public Optional<QuestionModel> getQuestionById(@PathVariable("id") Long id){
        return this.questionService.getQuestionById(id);
    }
}
