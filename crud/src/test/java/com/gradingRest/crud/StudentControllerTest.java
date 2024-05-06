package com.gradingRest.crud;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gradingRest.crud.controllers.StudentController;
import com.gradingRest.crud.models.StudentModel;
import com.gradingRest.crud.services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Optional;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private static MockMvc mockMvc;

    @MockBean
    private static StudentService studentService;

    @Test
    public static void testGetStudents() throws Exception {

        ArrayList<StudentModel> students = new ArrayList<>();
        students.add(new StudentModel());
        students.add(new StudentModel());

        when(studentService.getStudents()).thenReturn(students);

        mockMvc.perform(MockMvcRequestBuilders.get("/student"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public static void testInsertStudent() throws Exception {

        StudentModel student = new StudentModel();
        student.setName("John Doe");


        when(studentService.insertStudent(any(StudentModel.class))).thenReturn(student);


        mockMvc.perform(MockMvcRequestBuilders.post("/student")
                        .content(asJsonString(student))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.name").value("John Doe"));
    }

    @Test
    public static void testGetStudentById() throws Exception {

        Long studentId = 1L;
        StudentModel student = new StudentModel();
        student.setName("John Doe");


        when(studentService.getById(studentId)).thenReturn(Optional.of(student));


        mockMvc.perform(MockMvcRequestBuilders.get("/student/{id}", studentId))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.name").value("John Doe"));
    }


    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}