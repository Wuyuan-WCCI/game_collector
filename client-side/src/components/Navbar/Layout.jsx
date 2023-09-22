import Nav from "./Nav";
import style from "./Nav.module.css";
import PropTypes from "prop-types";

const Layout = (props) => {
  return (
    <div>
      <Nav />

      <main className={style.main}>
        {props.children}
        {/* {props} */}
      </main>
    </div>
  );
};
Layout.propTypes = {
  children: PropTypes.string,
};

export default Layout;
