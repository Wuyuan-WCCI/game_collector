import { useState } from 'react';

const SignupPage = () => {
  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [email, setEmail] = useState('');
  const url = 'http://localhost:7098/register';


  const handleSignup = async () => {
    try {
      // Perform client-side validation
      if (password !== confirmPassword) {
        console.error('Passwords do not match');
        return;
      }

      // Make a POST request to your backend API to create a new user account
      const response = await fetch(url, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({userName, password, email }),
      });

      if (response.ok) {
        // Successful registration, you can redirect to a login page or perform other actions
        console.log('Registration successful');
      } else {
        // Handle registration failure, show error message to the user
        console.error('Registration failed');
      }
    } catch (error) {
      console.error('An error occurred during registration', error);
    }
  };

  return (
    <div>
      <h2>Sign Up</h2>
      <form>
        <input
          type="userName"
          placeholder="Username"
          value={userName}
          onChange={(e) => setUserName(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <input
          type="password"
          placeholder="Confirm Password"
          value={confirmPassword}
          onChange={(e) => setConfirmPassword(e.target.value)}
        />
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <button type="button" onClick={handleSignup}>
          Sign Up
        </button>
      </form>
    </div>
  );
};

export default SignupPage;
