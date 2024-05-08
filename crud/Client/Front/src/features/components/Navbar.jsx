import { Link } from "react-router-dom";
//Link from react router is like a big anchor, it really helps when it comes to redirecting trafic to another link or in this case that we are using a CRUD handle the path
const NavBar = ()=>{
    return (
        <nav
        className="navbar"
        >
        <Link to="/">
        <section
        className="navbar-options"
        >Home</section>
        </Link>
        <Link to="/showStudents">
        <section
        className="navbar-options"
        >Lista Estudiantes</section>
        </Link>
        <Link to="/examSolution">
        <section
        className="navbar-options"
        >Responder Examen</section>
        </Link>
        </nav>
    )
}
export default NavBar