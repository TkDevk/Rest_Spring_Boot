package com.gradingRest.crud.controllers;
import com.gradingRest.crud.models.QuestionModel;
import com.gradingRest.crud.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
//Allow methods and connection from my Front
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/questions")
public class QuestionController {
    //Inject service
    @Autowired
    private QuestionService questionService;
    //Jpa.Repository Methods
    @GetMapping
    public ArrayList<QuestionModel> getQuestions(){
        //provide helpful methods
        return this.questionService.getQuestions();
    }

    //Check if the exam exists
    @PostMapping("/add/{examId}")
    public String addQuestionToExam(@PathVariable Long examId, @RequestBody QuestionModel question) {
        boolean success = questionService.addQuestionToExam(examId, question);
        if (success) {
            return "Your question have been successfully added.";
        } else {
            return "I can't find your answer.";
        }
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
