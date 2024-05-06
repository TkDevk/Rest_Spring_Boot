package com.gradingRest.crud.controllers;
import com.gradingRest.crud.models.ExamModel;
import com.gradingRest.crud.models.QuestionModel;
import com.gradingRest.crud.models.StudentModel;
import com.gradingRest.crud.services.ExamService;
import com.gradingRest.crud.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Allow Rest Controller methods
@RestController

@RequestMapping("/exam")
public class ExamController {
    //Inject service
    @Autowired
    private StudentService studentService;
    @Autowired
    //Inject service
    private ExamService examService;

    @GetMapping
    public ArrayList<ExamModel> getExams() {
        return this.examService.getExams();
    }

    //Using cors in order to allow request and methods to this endpoint
    @PostMapping
    @CrossOrigin(origins = "http://localhost:5173/")
    public ExamModel insertExam(@RequestBody ExamModel exam) {
        // Get students
        List<StudentModel> students = studentService.getStudents();

        // Set a new exam to each Student
        for (StudentModel student : students) {
            // Add Student to Exam
            exam.setStudent(student);
            // Add exam to a list which belongs to each student
            student.getExams().add(exam);
        }
        // Get all the questions related to the exam
        List<QuestionModel> questions = exam.getQuestions();

        // Set variable to get Total Score
        int totalScore = 0;

        // Iterate for each question and get the answer
        for (QuestionModel question : questions) {
            // Get the right answer's index
            int correctAnswerIndex = exam.getCorrect_answer();

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
            String studentAnswer = getChoseAnswer();

            // Check if the choosen answer is the right one
            if (selectedAnswer != null && selectedAnswer.equals(studentAnswer)) {
                // Sumar 25 puntos al puntaje total
                totalScore += 25;
            }
        }

        // Asign total score to exam
        exam.setScore(totalScore);

        // Save exam with data about the student and the answer
        return examService.insertExam(exam);

    }

    private String getChoseAnswer() {

        return "Chose answer";
    }
}