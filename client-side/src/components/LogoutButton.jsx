import React from 'react';
import { useNavigate } from 'react-router-dom'

const buttonStyle = {
    backgroundColor: 'transparent',
    border: 'none',
    cursor: 'pointer',
    color: 'white', 
    transition: 'color 0.3s',
    
  };

  const hoverStyle = {
    color: 'red', // Text color when hovered
  };

const LogoutButton = () => {
    const navigate = useNavigate();
  const handleLogout = () => {
    // Perform logout logic here, such as clearing user data from localStorage
    localStorage.removeItem('authToken');
    localStorage.removeItem('userName');
    localStorage.removeItem('userId')
    alert('You have Logout!')
    
  };

  const handleMouseEnter = (event) => {
    // Apply hover style when the mouse enters the button
    event.target.style.color = hoverStyle.color;
  };

  const handleMouseLeave = (event) => {
    // Restore the default style when the mouse leaves the button
    event.target.style.color = buttonStyle.color;
  };

  return (
    <button
      style={buttonStyle}
      onMouseEnter={handleMouseEnter}
      onMouseLeave={handleMouseLeave}
      onClick={handleLogout}
    ><a href="http://localhost:5173/">Logout</a>
      
    </button>
  );
};

export default LogoutButton;
