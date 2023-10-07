
import { Link } from 'react-router-dom';
import { useState, useEffect } from 'react';


  const UserProfile = () => {
  const [user, setUser] = useState(null);
  

  useEffect(() => {
    // Retrieve the authentication token from where it's stored (localStorage, state, etc.)
    const authToken = localStorage.getItem('authToken'); 
    const userId = localStorage.getItem('userId')

    if (authToken) {
      // Make an authenticated API request to fetch user details
      fetch(`http://localhost:7098/user/id/${userId}`, {
        method: 'GET',
        headers: {
          'Authorization': `Bearer ${authToken}`, // Include the token in the request headers
        },
      })
        .then((response) => {
          if (response.ok) {
            return response.json();
          } else {
            throw new Error('Failed to fetch user details');
          }
        })
        .then((userData) => {
          setUser(userData); // Set the user data in the component's state
        })
        .catch((error) => {
          console.error('Error fetching user details:', error);
        });
    }
  }, []);

  return (
    <div className="container">
      <h2>User Profile</h2>
      {user ? (
        <>
        <div className='box' key={user.id}>
          <p>User ID: {user.id}</p>
          <p>Username: {user.userName}</p>
          <p>Email: {user.email}</p>

          {/* Add more user details here */}
        </div>
              <br></br>
      <br></br>
      <br></br>
      <Link to="/owned-list">
      <h2>My OwnedList</h2>
            </Link>
      <div className='box' key={user.id}>
          <p>OwnedList: </p>

        </div>
      <br></br>
      <br></br>
      <br></br>
      <Link to="/wish-list">
      <h2>My Wishlist</h2>
            </Link>
      <div className='box' key={user.id}>
          <p>WishList:</p>

        </div>
        </>
      ) : (
        <p>Loading user details...</p>
      )}

    </div>
  );
};

export default UserProfile;