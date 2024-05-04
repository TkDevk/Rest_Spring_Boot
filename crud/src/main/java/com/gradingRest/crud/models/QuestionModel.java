package com.gradingRest.crud.models;

import jakarta.persistence.*;


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
        private String forth_answer;

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

        public String getForth_answer() {
                return forth_answer;
        }

        public void setForth_answer(String forth_answer) {
                this.forth_answer = forth_answer;
        }

        public ExamModel getExam() {
                return exam;
        }

        public void setExam(ExamModel exam) {
                this.exam = exam;
        }
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "FK_exam_id")
        private ExamModel exam;


}
