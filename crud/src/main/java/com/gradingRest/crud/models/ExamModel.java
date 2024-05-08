package com.gradingRest.crud.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//using entity to show the relation between my classes model
@Entity
@Table(name = "exam")
public class ExamModel {
    //Creating relate table information (Id, columns, FK's)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exam_id;

    @Column
    private String question;

    //IM setting this entity as one student can have many Exams

    public void setQuestions(List<QuestionModel> questions) {
        this.questions = questions;
    }

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<QuestionModel> questions;
    //Big loop let's ignore it because my FK per each exam is iterating each exam
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_student_id")
    private StudentModel student;


    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<ScoreModel> scores;
    @Column
    private int correct_answer;

    public List<ScoreModel> getScores() {
        return scores;
    }

    public void setScores(List<ScoreModel> scores) {
        this.scores = scores;
    }


    public Long getExam_id() {
        return exam_id;
    }

    public void setExam_id(Long exam_id) {
        this.exam_id = exam_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<QuestionModel> getQuestions() {
        return questions;
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public int getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(int correct_answer) {
        this.correct_answer = correct_answer;
    }

    public ExamModel() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(QuestionModel question) {
        question.setExam(this);
        this.questions.add(question);
    }

    public void addScore(ScoreModel score) {
        score.setExams(this);
        this.scores.add(score);
    }

    public void setScore(int totalScore) {
    }
}