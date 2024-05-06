import { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
const BASEURL = "http://localhost:4000/student";

const CreateStudent = () => {
  const [warning, setWarning] = useState(false);
  const [showButton, setShowButton] = useState(false);
  const [inputDataStudent, setInputDataStudent] = useState({
    studentName: "",
    studentCity: "",
    //Int value set as empty.String in the Wonderful JS
    //Just for comsetic purposes 
    studentAge: "",
    studentTimeZone: "",
  });

  const onSubmit = async (e) => {
    e.preventDefault();
    //Warning the user about the empty info
    if (
      inputDataStudent.studentName == "" ||
      inputDataStudent.studentCity == "" ||
      inputDataStudent.studentAge == 0 ||
      inputDataStudent.studentTimeZone == ""
    ) {
      setWarning(true);
    } else {
      try {
        await axios.post(BASEURL, {
          name: inputDataStudent.studentName,
          city: inputDataStudent.studentCity,
          age: inputDataStudent.studentAge,
          timeZone: inputDataStudent.studentTimeZone,
        });
      } catch (error) {
        console.log(error);
      }

      setInputDataStudent({
        studentName: "",
        studentCity: "",
        studentAge: "",
        studentTimeZone: "",
      });
      setWarning("");
      setShowButton(true);
      setWarning(false);
    }
  };

  const handleInput = (e) => {
    const { name, value } = e.target;
    setInputDataStudent({
      ...inputDataStudent,
      [name]: value,
    });
  };

  return (
    <>
      <form className="form-container" onSubmit={onSubmit}>
        <h1>Crear Estudiante</h1>
        <section 
        className="student-container"
        >
          <input
            type="text"
            onChange={handleInput}
            name="studentName"
            value={inputDataStudent.studentName}
            placeholder="Ingresa nombre completo del estudiante"
          />
          <input
            type="text"
            onChange={handleInput}
            name="studentCity"
            value={inputDataStudent.studentCity}
            placeholder="Ingresa ciudad del estudiante"
          />
          <input
            type="number"
            onChange={handleInput}
            name="studentAge"
            value={inputDataStudent.studentAge}
            placeholder="Ingresa edad del estudiante"
          />
          <input
            type="text"
            onChange={handleInput}
            name="studentTimeZone"
            value={inputDataStudent.studentTimeZone}
            placeholder="Ingresa zona horaria del estudiante"
          />
        </section>

        <button>Enviar </button>
      </form>
       {warning && <p className="warning-msg">Por favor ingresa todos los datos</p>}
       {showButton && <Link to="/addExam"><button> Crear Examen </button></Link>} {/* Mostrar el botón después de enviar el formulario */}
    </>
  );
};
export default CreateStudent;

/**
 student_name
 city
 age
 time_zone
 * 
 */
