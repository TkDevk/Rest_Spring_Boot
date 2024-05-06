import { useState } from "react"
import axios from "axios";
const BASEURL = "http://localhost:4000/student";

const CreateStudent = ()=>{
    const [warning, setWarning] = useState("");
    const [inputDataStudent, setInputDataStudent] = useState({
        studentName:"",
        studentCity:"",
        studentAge: 0,
        studentTimeZone:""
    });
  
    const onSubmit = async(e)=>{
        e.preventDefault();
        //Warning the user about the empty info
        if(inputDataStudent.studentName=="" 
        || inputDataStudent.studentCity==""
        || inputDataStudent.studentAge==0 
        || inputDataStudent.studentTimeZone==""){
          setWarning("Por favor ingresa todos los datos")
        }else{
            try{
                await axios.post(BASEURL,{
                    name: inputDataStudent.studentName,
                    city: inputDataStudent.studentCity,
                    age: inputDataStudent.studentAge,
                    timeZone: inputDataStudent.studentTimeZone
                })
            }catch(error){
                console.log(error);
            }
    
            setInputDataStudent({
                studentName:"",
                studentCity:"",
                studentAge: 0,
                studentTimeZone:""
            });
            setWarning("");
        }


    }

    const handleInput = (e)=>{
       const {name, value} = e.target;
       setInputDataStudent({
          ...inputDataStudent,
          [name]:value
       });
    }

    return (
        <>
        <form onSubmit={onSubmit}>
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
          placeholder="Ingresa tu ciudad"
          />
          <input 
          type="number"
          onChange={handleInput}
          name="studentAge" 
          value={inputDataStudent.studentAge}
          placeholder="Ingresa tu edad"
          />
          <input 
          type="text" 
          onChange={handleInput}
          name="studentTimeZone"
          value={inputDataStudent.studentTimeZone}
          placeholder="Ingresa tu zona horaria"
          />
          <button>Enviar </button>
        </form>
        {setWarning?warning:null}
        </>
    ) 
}
export default CreateStudent

/**
 student_name
 city
 age
 time_zone
 * 
 */