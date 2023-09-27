// src/components/Login.js
import React, { useState } from 'react';
import './LoginPage.module.css';
import { useNavigate } from 'react-router-dom'


function Login() {
  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate()
  

  const handleLogin = async () => {
    // Make an API request to your Spring Boot backend here
    try {
      const response = await fetch('http://localhost:7098/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ userName, password }),
      });

      if (response.ok) {
        navigate('/user-detail', );
        console.log('Request Data:', { userName, password });
        
        alert('User Login successfully');
        
       
      } else {
        console.log("Username or password is incorrect.")
        alert("Username or password is incorrect.")
      }
    } catch (error) {
      console.error('Error: login failed', error);
    }
  };


  return (
    <div className="login-form">
      <h2>Login</h2>
      <p>Username</p>
      
      <form>
        <input
          type="userName"
          placeholder="UserName"
          value={userName}
          onChange={(e) => setUserName(e.target.value)}
        />
        <p>Password</p>
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      
      <button type = "Submit" onClick={handleLogin}>Login</button>
      <button>Create Account</button>
      </form>
    </div>
  );
}

export default Login;



