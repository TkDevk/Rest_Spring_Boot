import { Link } from "react-router-dom"

const Home = ()=>{
    return (
        <>
           <h1 className="home-title">Bienvenid@</h1>
           <p className="home-text">Para comenzar, primero crea un estudiante, puedes encontrar la seccion de estudiantes en la parte superior pero solo veras estudiantes una vez que los crees</p>
           <p className="home-text">Despues de crear un estudiante veras la opcion de crear examen, comencemos creando dos examenes, dale click al boton Añadir Estudiante</p>
           <Link to="/addStudent"><button className="home-btn">Añadir Estudiante</button></Link>
           
        </>
    )
}
export default Home