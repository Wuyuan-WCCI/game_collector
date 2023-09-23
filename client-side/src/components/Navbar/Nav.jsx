// import { Link } from "react-router-dom";
import style from "./Nav.module.css";


const Nav = () => {
  return (
    <header className={style.header}>
        <h1>GAME COLLECTION APP</h1>
      <nav>
            <a href="http://localhost:5173/">Home</a>
            <a href="http://localhost:5173/owned-list">Owned Games</a>
            <a href="http://localhost:5173/wish-list">Wish List</a>
            <a href="http://localhost:5173/discover">Discover</a>
            <a href="http://localhost:5173/login">Login/SignUp</a>
        </nav>
        {/* <nav>
          <img src="client-side\src\assets\MysteryEducator.svg" width="60px" />
          <ul>
            GCA
            <Link to="/login">
              <li>Login/SignUp</li>
            </Link>
            <Link to="/owned-list">
              <li>Owned Games</li>
            </Link>
            <Link to="/wish-list">
              <li>Wish List</li>
            </Link>
            <Link to="/discover">
            <li>Discover</li>
            </Link>
          </ul>
        </nav> */}
    </header>
  );
};

export default Nav;


{/* <nav className="navbar navbar-expand-lg navbar-light bg-light">
  <a className="navbar-brand" href="#">GCA</a>
  <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span className="navbar-toggler-icon"></span>
  </button>

  <div className="collapse navbar-collapse" id="navbarSupportedContent">
    <ul className="navbar-nav mr-auto">
      <li className="nav-item active">
        <a className="nav-link" href="#">Home <span className="sr-only">(current)</span></a>
      </li>
      <li className="nav-item">
        <a className="nav-link" href="#">Discover</a>
      </li>
      <li className="nav-item dropdown">
        <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          My Games
        </a>
        <div className="dropdown-menu" aria-labelledby="navbarDropdown">
          <a className="dropdown-item" href="#">Owned Games</a>
          <a className="dropdown-item" href="#">Wish List</a>
          <div className="dropdown-divider"></div>
          <a className="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li className="nav-item">
        <a className="nav-link disabled" href="#">Login/SignUp</a>
      </li>
    </ul>
    <form className="form-inline my-2 my-lg-0">
      <input className="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"/>
      <button className="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav> */}