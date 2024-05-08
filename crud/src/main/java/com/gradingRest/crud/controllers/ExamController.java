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
        // Save exam with data about the student and the answer
        return examService.insertExam(exam);

    }

}