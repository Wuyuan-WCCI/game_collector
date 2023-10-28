
import { Link } from "react-router-dom";
import LoginPage from "../components/LoginPage";

//  <LoginPage /> 

const Login = () => {
    return (
      <>

    {/* Form NUMBER 1 */}
    <LoginPage />

    {/* Form NUMBER 2 */} 
             <div className="login-form">
            <h1>Codename Collection</h1>
            <form action="#" method="POST">
              <p>Username</p>
              <input type="userName" name="userName" placeholder="Username" />
              <p>Password</p>
              <input type="password" name="password" placeholder="Password" />
              <span>
                <button type="submit">Login</button>
                <Link to="/signup">
            <button>Create Account</button>
          </Link>
              </span>
            </form>
          </div>  

    
      </>
    );
  };
  
  export default Login;