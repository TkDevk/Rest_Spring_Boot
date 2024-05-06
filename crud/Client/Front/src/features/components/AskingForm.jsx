import { useState } from "react";
import axios from "axios";
const BASEURL = "http://localhost:4000";

const AskingForm = () => {

  const [warning, setWarning] = useState("");  
  //Set values in order to handle the information
  const [inputFirstQuestion, setInputFirstQuestion] = useState({
    question: "",
    correctAnswer: "",
  });
  const [inputDataFirstAnswer, setInputDataFirstAnswer] = useState({
    answerOne: "",
    answerTwo: "",
    answerThird: "",
    answerFourth: "",
  });
  /**
  There are four question per Exam so it's mandatory create 4 handle statements
   */
  const [inputSecondQuestion, setInputSecondQuestion] = useState({
    question: "",
    correctAnswer: "",
  });
  const [inputDataSecondAnswer, setInputDataSecondAnswer] = useState({
    answerOne: "",
    answerTwo: "",
    answerThird: "",
    answerFourth: "",
  });

  /**
  Third handle statements
   */

  const [inputThirdQuestion, setInputThirdQuestion] = useState({
    question: "",
    correctAnswer: "",
  });
  const [inputDataThirdAnswer, setInputDataThirdAnswer] = useState({
    answerOne: "",
    answerTwo: "",
    answerThird: "",
    answerFourth: "",
  });
  /**
  Fourth handle statements
   */
  const [inputFourthQuestion, setInputFourthQuestion] = useState({
    question: "",
    correctAnswer: "",
  });
  const [inputDataFourthAnswer, setInputDataFourthAnswer] = useState({
    answerOne: "",
    answerTwo: "",
    answerThird: "",
    answerFourth: "",
  });

  /**
  Creating onSubmit function in order to handle the request from form/client to backend 
   */
  const onSubmit = async (e) => {
    e.preventDefault();
    //Warning the user about the empty info
    if(inputFirstQuestion.correctAnswer==""
    ||inputFirstQuestion.question==""
    ||inputDataFirstAnswer.answerOne=="" 
    ||inputDataFirstAnswer.answerTwo==""
    ||inputDataFirstAnswer.answerThird==""
    ||inputDataFirstAnswer.answerFourth==""
    ||inputSecondQuestion.correctAnswer==""
    ||inputSecondQuestion.question==""
    ||inputDataSecondAnswer.answerOne=="" 
    ||inputDataSecondAnswer.answerTwo==""
    ||inputDataSecondAnswer.answerThird==""
    ||inputDataSecondAnswer.answerFourth==""
    ||inputThirdQuestion.question==""
    ||inputDataThirdAnswer.answerOne=="" 
    ||inputDataThirdAnswer.answerTwo==""
    ||inputDataThirdAnswer.answerThird==""
    ||inputDataThirdAnswer.answerFourth==""
    ||inputFourthQuestion.question==""
    ||inputDataFourthAnswer.answerOne=="" 
    ||inputDataFourthAnswer.answerTwo==""
    ||inputDataFourthAnswer.answerThird==""
    ||inputDataFourthAnswer.answerFourth==""
    ){
      setWarning("Porfavor ingresa todos los valores")
    }else{
       
   
    /*
    Creating a Try catch in order to handle all the inputs and also to asign in my questionsData Object per iteration in the BASEURL/questions/add/{id}, each index it will increment by 1
    */ 
    try {
      const response = await axios.get(`${BASEURL}/exam`);
      const maxId = response.data.length;
      const questionsData = [
        { question: inputFirstQuestion, answers: inputDataFirstAnswer },
        { question: inputSecondQuestion, answers: inputDataSecondAnswer },
        { question: inputThirdQuestion, answers: inputDataThirdAnswer },
        { question: inputFourthQuestion, answers: inputDataFourthAnswer },
      ];

      await Promise.all(
        questionsData.map(async (data, index) => {
          await axios.post(`${BASEURL}/exam`, {
            question: data.question.question,
            correct_answer: data.question.correctAnswer,
          });
          await axios.post(`${BASEURL}/questions/add/${maxId + index + 1}`, {
            first_answer: data.answers.answerOne,
            second_answer: data.answers.answerTwo,
            third_answer: data.answers.answerThird,
            fourth_answer: data.answers.answerFourth,
          });
        })
      );
    } catch (error) {
      console.log(error);
    }

    //As soon as the data is send all the values will be reset

    setInputDataFirstAnswer({
      answerOne: "",
      answerTwo: "",
      answerThird: "",
      answerFourth: "",
    });
    setInputFirstQuestion({
      question: "",
      correctAnswer: "",
    });
    //////////
    setInputDataSecondAnswer({
      answerOne: "",
      answerTwo: "",
      answerThird: "",
      answerFourth: "",
    });
    setInputSecondQuestion({
      question: "",
      correctAnswer: "",
    });
    ////////////
    setInputDataThirdAnswer({
      answerOne: "",
      answerTwo: "",
      answerThird: "",
      answerFourth: "",
    });
    setInputThirdQuestion({
      question: "",
      correctAnswer: "",
    });
    ////////////
    setInputDataFourthAnswer({
      answerOne: "",
      answerTwo: "",
      answerThird: "",
      answerFourth: "",
    });
    setInputFourthQuestion({
      question: "",
      correctAnswer: "",
    });
    setWarning("");
  }
  };

  //Create new setValue object for each question and answers
  //Each input will have a handler
  const handleInputFirst = (e) => {
    const { name, value } = e.target;

    //First question
    setInputFirstQuestion({
      ...inputFirstQuestion,
      [name]: value,
    });

    setInputDataFirstAnswer({
      ...inputDataFirstAnswer,
      //property[]
      [name]: value,
    });
  };

  const handleInputSecond = (e) => {
    const { value, name } = e.target;
    //Second question
    setInputSecondQuestion({
      ...inputSecondQuestion,
      [name]: value,
    });

    setInputDataSecondAnswer({
      ...inputDataSecondAnswer,
      //property[]
      [name]: value,
    });
  };
  const handleInputThird = (e) => {
    const { value, name } = e.target;
    //Third question
    setInputThirdQuestion({
      ...inputThirdQuestion,
      [name]: value,
    });

    setInputDataThirdAnswer({
      ...inputDataThirdAnswer,
      //property[]
      [name]: value,
    });
  };
  const handleInputFourth = (e) => {
    const { value, name } = e.target;
    //Fourth question
    setInputFourthQuestion({
      ...inputFourthQuestion,
      [name]: value,
    });
    setInputDataFourthAnswer({
      ...inputDataFourthAnswer,
      //property[]
      [name]: value,
    });
  };

  return (
    <>
      <form onSubmit={onSubmit}>
        <section>
          {/*First Input*/}
          <input
            type="text"
            name="question"
            onChange={handleInputFirst}
            value={inputFirstQuestion.question}
            placeholder="Ingresa la pregunta"
          />
          <input
            type="text"
            name="answerOne"
            onChange={handleInputFirst}
            value={inputDataFirstAnswer.answerOne}
            placeholder="Ingresa la primera pregunta"
          />
          <input
            type="text"
            name="answerTwo"
            onChange={handleInputFirst}
            value={inputDataFirstAnswer.answerTwo}
            placeholder="Ingresa la segunda pregunta"
          />
          <input
            type="text"
            name="answerThird"
            onChange={handleInputFirst}
            value={inputDataFirstAnswer.answerThird}
            placeholder="Ingresa la tercera pregunta"
          />
          <input
            type="text"
            name="answerFourth"
            value={inputDataFirstAnswer.answerFourth}
            onChange={handleInputFirst}
            placeholder="Ingresa la cuarta pregunta"
          />
          <input
            type="number"
            name="correctAnswer"
            value={inputFirstQuestion.correctAnswer}
            onChange={handleInputFirst}
            placeholder="Ingresa cual es la respuesta correcta"
          />
        </section>
        {/*Second Input*/}
        <section>
          <input
            type="text"
            name="question"
            onChange={handleInputSecond}
            value={inputSecondQuestion.question}
            placeholder="Ingresa la pregunta"
          />
          <input
            type="text"
            name="answerOne"
            onChange={handleInputSecond}
            value={inputDataSecondAnswer.answerOne}
            placeholder="Ingresa la primera pregunta"
          />
          <input
            type="text"
            name="answerTwo"
            onChange={handleInputSecond}
            value={inputDataSecondAnswer.answerTwo}
            placeholder="Ingresa la segunda pregunta"
          />
          <input
            type="text"
            name="answerThird"
            onChange={handleInputSecond}
            value={inputDataSecondAnswer.answerThird}
            placeholder="Ingresa la tercera pregunta"
          />
          <input
            type="text"
            name="answerFourth"
            value={inputDataSecondAnswer.answerFourth}
            onChange={handleInputSecond}
            placeholder="Ingresa la cuarta pregunta"
          />
          <input
            type="number"
            name="correctAnswer"
            value={inputSecondQuestion.correctAnswer}
            onChange={handleInputSecond}
            placeholder="Ingresa cual es la respuesta correcta"
          />
        </section>
        {/*Third Input*/}
        <section>
          <input
            type="text"
            name="question"
            onChange={handleInputThird}
            value={inputThirdQuestion.question}
            placeholder="Ingresa la pregunta"
          />
          <input
            type="text"
            name="answerOne"
            onChange={handleInputThird}
            value={inputDataThirdAnswer.answerOne}
            placeholder="Ingresa la primera pregunta"
          />
          <input
            type="text"
            name="answerTwo"
            onChange={handleInputThird}
            value={inputDataThirdAnswer.answerTwo}
            placeholder="Ingresa la segunda pregunta"
          />
          <input
            type="text"
            name="answerThird"
            onChange={handleInputThird}
            value={inputDataThirdAnswer.answerThird}
            placeholder="Ingresa la tercera pregunta"
          />
          <input
            type="text"
            name="answerFourth"
            value={inputDataThirdAnswer.answerFourth}
            onChange={handleInputThird}
            placeholder="Ingresa la cuarta pregunta"
          />
          <input
            type="number"
            name="correctAnswer"
            value={inputThirdQuestion.correctAnswer}
            onChange={handleInputThird}
            placeholder="Ingresa cual es la respuesta correcta"
          />
        </section>
        {/*Fourth Input*/}
        <section>
          <input
            type="text"
            name="question"
            onChange={handleInputFourth}
            value={inputFourthQuestion.question}
            placeholder="Ingresa la pregunta"
          />
          <input
            type="text"
            name="answerOne"
            onChange={handleInputFourth}
            value={inputDataFourthAnswer.answerOne}
            placeholder="Ingresa la primera pregunta"
          />
          <input
            type="text"
            name="answerTwo"
            onChange={handleInputFourth}
            value={inputDataFourthAnswer.answerTwo}
            placeholder="Ingresa la segunda pregunta"
          />
          <input
            type="text"
            name="answerThird"
            onChange={handleInputFourth}
            value={inputDataFourthAnswer.answerThird}
            placeholder="Ingresa la tercera pregunta"
          />
          <input
            type="text"
            name="answerFourth"
            value={inputDataFourthAnswer.answerFourth}
            onChange={handleInputFourth}
            placeholder="Ingresa la cuarta pregunta"
          />
          <input
            type="number"
            name="correctAnswer"
            value={inputFourthQuestion.correctAnswer}
            onChange={handleInputFourth}
            placeholder="Ingresa cual es la respuesta correcta"
          />
        </section>
        <button>Enviar</button>
      </form>
      {setWarning?warning:null}
    </>
  );
};
export default AskingForm;
