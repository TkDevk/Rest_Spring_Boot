import { Link } from "react-router-dom";

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
        
        </nav>
    )
}
export default NavBar