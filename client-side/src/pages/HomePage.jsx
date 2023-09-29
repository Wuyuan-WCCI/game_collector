// import React from 'react';
// const HomePage = () => {
//   return(
//     <>
//     <br></br>
//     <br></br>
//     <br></br>
//     <h1>Welcome Home!</h1>
//     </>
//   );
    
//   };
  
//   export default HomePage;

import { Link } from 'react-router-dom';

const HomePage = () => {
  return (
    <>
      <br></br>
      <br></br>
      <br></br>
      <h1>Welcome Home!</h1>
      <Link to="/wish-list">Go to WishList</Link>
      <br />
      <Link to="/owned-list">Go to OwnedList</Link>
      <br />
      <Link to="/discover">Go to Discovery</Link>
    </>
  );
};

export default HomePage;
