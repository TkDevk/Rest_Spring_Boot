package com.gradingRest.crud.models;

import jakarta.persistence.*;

import java.util.List;

//Generate table
@Entity
@Table(name = "student")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;
    @Column
    private String student_name;
    @Column
    private String city;
    @Column
    private int age;
    @Column
    private String time_zone;
    //entity just helped me to create the relation about one student can have many exams
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<ExamModel> exams;

    public Long getStudentId() {
        return student_id;
    }

    public void setStudentId(Long id) {
        this.student_id = id;
    }

    public String getName() {
        return student_name;
    }

    public void setName(String name) {
        this.student_name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTimeZone() {
        return time_zone;
    }

    public void setTimeZone(String time_zone) {
        this.time_zone = time_zone;
    }

    public List<ExamModel> getExams() {
        return exams;
    }

    public void setExams(List<ExamModel> exams) {
        this.exams = exams;
    }
}
