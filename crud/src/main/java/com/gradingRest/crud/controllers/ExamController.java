package com.gradingRest.crud.controllers;
import com.gradingRest.crud.models.ExamModel;
import com.gradingRest.crud.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private ExamService examService;
    @GetMapping
    public ArrayList<ExamModel> getExams(){
        return this.examService.getExams();
    }
    @PostMapping
    public ExamModel insertExam(@RequestBody ExamModel exam){
        return this.examService.insertExam(exam);
    }
    @GetMapping(path = "/{examId}")
    public Optional<ExamModel> getExamById(@PathVariable("examId") Long examId){
        return this.examService.getExamById(examId);
    }
}
