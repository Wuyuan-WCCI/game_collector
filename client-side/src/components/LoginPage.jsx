// src/components/Login.js
import React, { useState } from 'react';

function Login() {
  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');

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
        console.log('Request Data:', { userName, password });
      } else {
        console.log("Username or password is incorrect.")
      }
    } catch (error) {
      console.error('Error: login failed', error);
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <div>
        <input
          type="userName"
          placeholder="UserName"
          value={userName}
          onChange={(e) => setUserName(e.target.value)}
        />
      </div>
      <div>
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>
      <button onClick={handleLogin}>Login</button>
    </div>
  );
}

export default Login;



