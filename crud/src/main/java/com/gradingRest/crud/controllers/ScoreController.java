package com.gradingRest.crud.controllers;


import com.gradingRest.crud.models.ExamModel;
import com.gradingRest.crud.models.QuestionModel;
import com.gradingRest.crud.models.ScoreModel;
import com.gradingRest.crud.services.ExamService;
import com.gradingRest.crud.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Creating a controller to locate the score data
@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ExamService examService;

    //Checking those scores
    @GetMapping
    public ArrayList<ScoreModel> getScore() {
        //provide helpful methods
        return this.scoreService.getScore();
    }

    //As FK was setted in the ScoreModel now the next step is post the info but
    // adding to the related table that in this case is exam
    @PostMapping
    public ScoreModel insertAnswer(@RequestBody ScoreModel score) {
        // Get students
        List<ExamModel> exams = examService.getExams();

        // Set a new exam to each Student
        for (ExamModel exam : exams) {
            // Add Student to Exam
            score.setExam(exam);
            // Add exam to a list which belongs to each student
            exam.getScores().add(score);
        }
        // Get all the questions related to the exam
        return scoreService.insertAnswer(score);
    }

    @PostMapping("/total")
    public ScoreModel postTotalScore(@RequestBody ScoreModel score) {
        // Get all the questions related to the exam
        List<QuestionModel> questions = (List<QuestionModel>) score.getExams();

        // Set variable to get Total Score
        int totalScore = 0;

        // Iterate for each question and get the answer
        for (QuestionModel question : questions) {
            // Get the right answer's index
            int correctAnswerIndex = question.getExam().getCorrect_answer();

            // Check what answer is correct and added it 25 points
            String selectedAnswer = null;
            switch (correctAnswerIndex) {
                case 1:
                    selectedAnswer = question.getFirst_answer();
                    break;
                case 2:
                    selectedAnswer = question.getSecond_answer();
                    break;
                case 3:
                    selectedAnswer = question.getThird_answer();
                    break;
                case 4:
                    selectedAnswer = question.getFourth_answer();
                    break;
                default:
                    // Check if the index belongs to one asnwer
                    break;
            }

            // Get the choosen answer by the Student
            String studentAnswer = String.valueOf(getChoseAnswer());

            // Check if the choosen answer is the right one
            if (selectedAnswer != null && selectedAnswer.equals(studentAnswer)) {
                // Add 25 points to total score
                totalScore += 25;
            }
        }

        // Asign total score to exam and returning it
        return score;
    }
    @GetMapping("/total")
    private ArrayList<ScoreModel> getChoseAnswer() {
        return this.scoreService.getScore();
    }

}
