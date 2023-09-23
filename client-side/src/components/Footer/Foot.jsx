import style from '../Footer/Foot.module.css'

const Foot = () => {
    return (
 <footer className={style.footer}>
    <div className="wrapper">
      <small>&copy;2017 <strong>Awesome Company</strong>, All Rights Reserved</small>
      <nav className="footer-nav">
        <a href="#">Back to Top</a>
        <a href="#">Terms of Use</a>
        <a href="#">Privacy</a>
      </nav>
    </div>
  </footer> 
    );
  };

export default Foot;