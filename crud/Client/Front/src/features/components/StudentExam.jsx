import { useState, useEffect } from "react";
import axios from "axios";

const BASEURL = "http://localhost:4000/student";

const StudentsList = () => {
 
  //Set two states one for the students, this on it will bring all the data because FK's
  const [students, setStudents] = useState([]);
  //This state allows the counting points process
  const [points, setPoints] = useState(0);

  // Get a request from BASEURL, as this it will come one with out rendering component i will pack it in a useEffect

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

  //Making a global function for the onChange method's input
  //Passing incoming args
  const handleAnswerChange = (studentId, questionIndex, answer) => {
    //Look for studentId
    const student = students.find((student) => student.studentId === studentId);
    if (!student) return;
    // Get the correct answer per question
    const correctAnswer0 = student.exams[0].correct_answer;
    console.log(correctAnswer0);
    const correctAnswer1 = student.exams[1].correct_answer;
    console.log(correctAnswer1);
    const correctAnswer2 = student.exams[2].correct_answer;
    console.log(correctAnswer2);
    const correctAnswer3 = student.exams[3].correct_answer;
    console.log(correctAnswer3);
    
    // See if any value match, if so, it will increment points by 25
 if (answer == correctAnswer0) {
  console.log(points);
  setPoints(points + 25);
  console.log("Correct Answer:", correctAnswer0);
} else if (answer == correctAnswer1) {
  setPoints(points + 25);
  console.log("Correct Answer:", correctAnswer1);
} else if (answer == correctAnswer2) {
  setPoints(points + 25);
  console.log("Correct Answer:", correctAnswer2);
} else if (answer == correctAnswer3) {
  setPoints(points + 25);
  console.log("Correct Answer:", correctAnswer3);
}
  //In this way we met the points requirements

  };
  //HandleSubmit to preven default form's behavior
  const handleSubmit = (e) => {
    e.preventDefault();

  };

  return (
    <>
    {/*Mapping the incoming students array data */}
      {students.map((student) => (
        <section className="show-list-container" key={student.studentId}>
          <h2 className="student_info">
            {student.name} - {student.age} - {student.city}
          </h2>
          <form onSubmit={handleSubmit}>
            <ul className="list-students-container">
              {student.exams.map((exam, index) => (
                <li className="list-style" key={exam.examId}>
                  {/*Checking the index and adding it by 1 to match the right answer and questions */} 
                  <p>
                    Pregunta {index + 1}: {exam.question}
                  </p>
                  <ol className="list-container-show-answer">
                    <li key={exam.id}>{exam.questions[0].first_answer}</li>
                    <li key={exam.id}>{exam.questions[0].second_answer}</li>
                    <li key={exam.id}>{exam.questions[0].third_answer}</li>
                    <li key={exam.id}>{exam.questions[0].fourth_answer}</li>
                  </ol>
                  {/*Setting propierties for input as global and general use */}
                  <label>
                    Ingresa tu respuesta:
                    <input
                      type="text"
                      name={`respuesta_${student.studentId}_${index}`}
                      placeholder="Respuesta correcta"
                      onBlur={(e) => {
                        handleAnswerChange(
                          student.studentId,
                          index,
                          e.target.value.trim()
                        );
                      }}
                    />
                  </label>
                </li>
              ))}
            </ul>
            <button
              type="submit"
              style={{
                display: "flex",
                alignSelf: "center",
                padding: ".3rem",
                marginLeft: "5rem",
              }}
            >
              Enviar respuestas
            </button>
          </form>
        </section>
      ))}
      <p style={{ color: 
        "white", 
        marginRight: 
        "5rem" }}
        >Puntos: 
        {points}
        </p>
    </>
  );
};

export default StudentsList;
