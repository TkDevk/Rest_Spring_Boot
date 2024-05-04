package com.gradingRest.crud.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "exam")
public class ExamModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exam_id;
    @Column
    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }



    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<QuestionModel> questions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_student_id")
    private StudentModel student;

    public Long getExamId() {
        return exam_id;
    }

    public void setExamId(Long id) {
        this.exam_id = id;
    }

    public List<QuestionModel> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionModel> questions) {
        this.questions = questions;
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public int getCorrectAnswer() {
        return correct_answer;
    }

    public void setCorrectAnswer(int correct_answer) {
        this.correct_answer = correct_answer;
    }

    private int correct_answer;
}
