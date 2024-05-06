package com.gradingRest.crud;

import static org.mockito.Mockito.*;

import com.gradingRest.crud.models.StudentModel;
import com.gradingRest.crud.repositories.IExamRepository;
import com.gradingRest.crud.repositories.IStudentRepository;
import com.gradingRest.crud.services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;


@SpringBootTest
public class StudentServiceTest {

    @MockBean
    private IStudentRepository studentRepository;

    @MockBean
    private IExamRepository examRepository;

    @Test
    public void testGetStudents() {
        ArrayList<StudentModel> students = new ArrayList<>();
        students.add(new StudentModel());
        students.add(new StudentModel());

        when(studentRepository.findAll()).thenReturn(students);

        StudentService studentService = new StudentService(studentRepository, examRepository);

        assert studentService.getStudents().size() == 2;

    }


}