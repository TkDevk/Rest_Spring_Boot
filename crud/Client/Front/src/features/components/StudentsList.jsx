import axios from "axios";
import { useState, useEffect } from "react";

const BASEURL = "http://localhost:4000/student";

const StudentsList = () => {
  const [students, setStudents] = useState([]);
 //Mapping the list of students
 //Getting the User data it's pretty due to FK's i don't have to worry to fetch and extra data and join it, everything comes in that json file.

 //Control the rendering as soon as the page get reloaded by any extra component
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(BASEURL);
        setStudents(response.data);
      } catch (error) {
        console.log(error);
      }
    };

    fetchData();
  }, []); 

  console.log(students);

  return (
    <>
     {/*Mapping a list of students with its atributtes */}
      {students.map(student => (
        <section className="show-list-container" key={student.studentId}>
          <h2 className="student_info">{student.name} - {student.age} - {student.city}</h2>
          <ul className="list-students-container">
            {student.exams.map(exam => (
              <li className="list-style" key={exam.examId}>
                <p>Pregunta: {exam.question}</p>
                <p>Respuesta correcta: {exam.correct_answer}</p>
                <ul>
                  <li>{exam.questions[0].first_answer}</li>
                  <li>{exam.questions[0].second_answer}</li>
                  <li>{exam.questions[0].third_answer}</li>
                  <li>{exam.questions[0].fourth_answer}</li>
                </ul>
              </li>
            ))}
          </ul>
        </section>
      ))}
    </>
  );
};

export default StudentsList;