// import React, { useEffect, useState } from 'react';
// import { useParams } from 'react-router-dom'; // Import useParams

// const UserDetail = () => {
//   const { id } = useParams(); // Use useParams to access the "id" parameter
//   const [user, setUser] = useState(null);

//   useEffect(() => {
//     // Fetch user details based on the user ID
//     // You should replace this with your API request to get user details
//     fetch(`http://localhost:7098/user/id/${id}`)
//       .then((response) => response.json())
//       .then((data) => {
//         setUser(data);
//       })
//       .catch((error) => {
//         console.error('Error fetching user details:', error);
//       });
//   }, [id]);

//   return (
//     <div>
//       <h2>User Detail</h2>
//       {user ? (
//         <div>
//           <p>User ID: {user.id}</p>
//           <p>Username: {user.userName}</p>
//           <p>Email: {user.email}</p>
//           {/* Add more user details here */}
//         </div>
//       ) : (
//         <p>Loading user details...</p>
//       )}
//     </div>
//   );
// };

// export default UserDetail;

import React, { useState, useEffect } from 'react';

const UserProfile = () => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    // Retrieve the authentication token from where it's stored (localStorage, state, etc.)
    const authToken = localStorage.getItem('authToken'); // You may need to adjust this based on your setup.

    if (authToken) {
      // Make an authenticated API request to fetch user details
      fetch('http://localhost:7098/user/id/{id}', {
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
    <div>
      <h2>User Profile</h2>
      {user ? (
        <div>
          <p>User ID: {user.id}</p>
          <p>Username: {user.username}</p>
          <p>Email: {user.email}</p>
          {/* Add more user details here */}
        </div>
      ) : (
        <p>Loading user details...</p>
      )}
    </div>
  );
};

export default UserProfile;
