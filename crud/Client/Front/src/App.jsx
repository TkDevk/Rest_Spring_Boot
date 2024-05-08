import { Route, Routes } from 'react-router'
import Home from './features/pages/Home'
import AddStudent from './features/pages/AddStudent'
import AddExam from './features/pages/AddExam'
import NavBar from './features/components/Navbar'
import ShowStudents from './features/pages/ShowStudents'
import AnswerExam from './features/pages/AnswerExam'

function App() {
  return (
    <>
      <main
      className="body-container"
      >
        <NavBar/>
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/addStudent" element={<AddStudent/>}/>
          <Route path="/addExam" element={<AddExam/>}/>
          <Route path="/showStudents" element={<ShowStudents/>}/>
          <Route path='/examSolution' element={<AnswerExam/>}/>
        </Routes>

      </main>
    </>
  );
}

export default App;
