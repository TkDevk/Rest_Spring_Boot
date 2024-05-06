package com.gradingRest.crud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrudApplicationTests {

	@Test
	void contextLoads() throws Exception {
		//ExamControllerTest.testGetExams();
		StudentControllerTest.testGetStudents();
		StudentControllerTest.testGetStudentById();
		StudentControllerTest.testInsertStudent();

	}

}
