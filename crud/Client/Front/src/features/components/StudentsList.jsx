import axios from "axios";
import { useState, useEffect } from "react";

const BASEURL = "http://localhost:4000/student";

const StudentsList = () => {
  const [students, setStudents] = useState([]);
//UseEffect it will be helpuful to control the render information
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
    {/**Map incoming data */}
      {students.map(student => (
        <section 
        className="show-list-container"
        key={student.studentId}>
          <h2
          className="student_info"
          >{student.name} - {student.age} - {student.city}</h2>
          <ul
          className="list-students-container"
          >
            {student.exams.map(exam => (
              <li 
              className="list-style"
              key={exam.examId}>
                <p>Pregunta: {exam.question}</p>
                <p>Respuesta correcta: {exam.correct_answer}</p>
              </li>
            ))}
          </ul>
        </section>
      ))}
    </>
  );
};

export default StudentsList;