package com.gradingRest.crud.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "score")
public class ScoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long score_id;

    public ExamModel getExam() {
        return exam;
    }

    public void setExam(ExamModel exam) {
        this.exam = exam;
    }

    @Column
    private int student_response;


    public Long getScore_id() {
        return score_id;
    }

    public void setScore_id(Long score_id) {
        this.score_id = score_id;
    }

    public int getStudent_response() {
        return student_response;
    }

    public void setStudent_response(int student_response) {
        this.student_response = student_response;
    }

    public ExamModel getExams() {
        return exam;
    }

    public void setExams(ExamModel exams) {
        this.exam = exam;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_exam_id")
    private ExamModel exam;

    public void setScore(int totalScore) {
    }
}
