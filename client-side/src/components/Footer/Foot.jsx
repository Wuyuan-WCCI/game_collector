import style from '../Footer/Foot.module.css'

const Foot = () => {
    return (
 <footer className={style.footer}>
    <div className="wrapper">
      <small>&copy;2023 <strong>WCCI Bootcamp</strong>, Codename VP</small>
      <nav className="footer-nav">
        <a href="#">Back to Top</a>
        <a href="#">Privacy</a>
      </nav>
    </div>
  </footer> 
    );
  };

export default Foot;