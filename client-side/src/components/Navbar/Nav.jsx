import { Link } from "react-router-dom";
import style from "./Nav.module.css";
// import

const Nav = () => {
  return (
    <header className={style.header}>
      <div>
        <nav>
          {/* <img src="client-side\src\assets\MysteryEducator.svg" width="60px" /> */}
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
            {/* <Link to="/discover"> */}
            <li>Discover</li>
            {/* </Link> */}
          </ul>
        </nav>
      </div>
    </header>
  );
};

export default Nav;
