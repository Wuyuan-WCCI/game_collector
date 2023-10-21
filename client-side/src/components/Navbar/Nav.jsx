// Nav.jsx

import style from "./Nav.module.css";
import LogoutButton from "../LogoutButton";

const Nav = () => {
  const userName = localStorage.getItem("userName");
  const authToken = localStorage.getItem("authToken");

  return (
    <header className={style.header}>
      <div
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <img className="logo-img" src="src/img/gc-logo.png"></img>
        <h1 style={{ color: "gold" }}>GAME COLLECTION APP</h1>
      </div>
      <nav>
        <a href="http://localhost:5173/">Home</a>
        <a href="http://localhost:5173/register">Register</a>
        <a href="http://localhost:5173/random-games">Random Games</a>
        <a href="http://localhost:5173/new-games">New Releases</a>
        <div className="dropdown">
          <a href="http://localhost:5173/user-detail" className="dropbtn">
            UserPage
          </a>
          <div className="dropdown-content">
            <a href="http://localhost:5173/owned-list">Owned Games</a>
            <a href="http://localhost:5173/wish-list">Wish List</a>
          </div>
        </div>
        {authToken ? (
          <>
            <a href="http://localhost:5173/user-detail">Welcome! {userName}</a>
            <LogoutButton /> {/* Add the LogoutButton component */}
          </>
        ) : (
          <a href="http://localhost:5173/login">
            <b>Login/SignUp</b>
          </a>
        )}
      </nav>
    </header>

    // <header className={style.header}>
    //   <h1 style={{ color: 'gold' }}>GAME COLLECTION APP</h1>
    //   <nav>
    //     <a href="http://localhost:5173/">Home</a>
    //     <a href="http://localhost:5173/owned-list">Owned Games</a>
    //     <a href="http://localhost:5173/wish-list">Wish List</a>
    //     <a href="http://localhost:5173/register">Register</a>
    //     <a href="http://localhost:5173/random-games">Random Games</a>
    //     <a href="http://localhost:5173/new-games">New Releases</a>
    //     <a href="http://localhost:5173/user-detail">UserPage</a>
    //     <a href="http://localhost:5173/discover">Discover</a>
    //     {authToken ? (
    //       <>
    //         <a href="http://localhost:5173/user-detail">Welcome! {userName}</a>
    //         <LogoutButton /> {/* Add the LogoutButton component */}
    //       </>
    //     ) : (
    //       <a href="http://localhost:5173/login">
    //         <b>Login/SignUp</b>
    //       </a>
    //     )}
    //   </nav>
    // </header>
  );
};

export default Nav;
