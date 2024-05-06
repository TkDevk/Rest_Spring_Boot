package com.gradingRest.crud.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

//Calling entity in order to get those helpful methods
@Entity
@Table(name = "question")
public class QuestionModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long question_id;
        @Column
        private String first_answer;
        @Column
        private String second_answer;
        @Column
        private String third_answer;
        @Column
        private String fourth_answer;

        public Long getQuestionId() {
                return question_id;
        }

        public void setQuestionId(Long id) {
                this.question_id = id;
        }

        public String getFirst_answer() {
                return first_answer;
        }

        public void setFirst_answer(String first_answer) {
                this.first_answer = first_answer;
        }

        public String getSecond_answer() {
                return second_answer;
        }

        public void setSecond_answer(String second_answer) {
                this.second_answer = second_answer;
        }

        public String getThird_answer() {
                return third_answer;
        }

        public void setThird_answer(String third_answer) {
                this.third_answer = third_answer;
        }

        public String getFourth_answer() {
                return fourth_answer;
        }

        public void setForth_answer(String forth_answer) {
                this.fourth_answer = fourth_answer;
        }

        public ExamModel getExam() {
                return exam;
        }

        public void setExam(ExamModel exam) {
                this.exam = exam;
        }
        //Same with Exam model
        //Big loop between the FK and the questions
        //Many questions can belong to one exam
        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "FK_exam_id")
        private ExamModel exam;

}