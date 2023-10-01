import  { useState, useEffect } from 'react';

function GameDetail({ gameId }) {
  const [game, setGame] = useState(null);

  useEffect(() => {
    // Fetch game details using the gameId when the component mounts
    fetch(`http://localhost:7098/game-detail/${gameId}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then((data) => {
        setGame(data);
      })
      .catch((error) => {
        console.error('Error fetching game details:', error);
      });
  }, [gameId]);

  if (!game) {
    return <p>Loading...</p>;
  }

  return (
    <div className='game-detail'>
      <h2>Game Details</h2>
      <p>Game ID: {game.id}</p>
      <p>Slug: {game.slug}</p>
      <p>Name: {game.name}</p>
      <p>OG Name: {game.name_original}</p>
      <p>Description: {game.description}</p>
      {/* Display other game details as needed */}
    </div>
  );
}

export default GameDetail;


// import { useEffect, useState } from 'react';

// function GameDetail({ match }) {
//   const [data, setData] = useState(null);
//   const [loading, setLoading] = useState(true);
//   const [error, setError] = useState(null);

//   // Define your WishList and OwnedList states
//   const [wishList, setWishList] = useState([]);
//   const [ownedList, setOwnedList] = useState([]);

//   const gameId = match.params.gameId; // Extract the gameId from the URL parameter

//   // Function to handle adding a game to the WishList
//   const handleButtonAddWishList = (game) => {
//     // Check if the game is already in the WishList to avoid duplicates
//     if (!wishList.some((item) => item.id === game.id)) {
//       // Add the game to the WishList
//       setWishList([...wishList, game]);
//     }
//   };

//   // Function to handle adding a game to the OwnedList
//   const handleButtonAddOwnedList = (game) => {
//     // Check if the game is already in the OwnedList to avoid duplicates
//     if (!ownedList.some((item) => item.id === game.id)) {
//       // Add the game to the OwnedList
//       setOwnedList([...ownedList, game]);
//     }
//   };

//   useEffect(() => {
//     // Define the URL of your backend API
//     const apiUrl = `http://localhost:7098/game-detail/${gameId}`;

//     fetch(apiUrl)
//       .then((response) => {
//         if (!response.ok) {
//           throw new Error('Network response was not ok');
//         }
//         return response.json();
//       })
//       .then((data) => {
//         setData(data);
//         setLoading(false);
//       })
//       .catch((error) => {
//         setError(error);
//         setLoading(false);
//       });
//   }, [gameId]); // Include gameId in the dependency array to refetch when it changes

//   if (loading) {
//     return <p>Loading...</p>; // You can show a loading indicator here
//   }

//   if (error) {
//     return <p>Error: {error.message}</p>; // Handle the error here
//   }

//   return (
//     <div>
//       {/* Display game details */}
//       <h1>Game Detail</h1>
//       <div className="container">
//         <div className="box" key={data.id}>
//           <div className="box-image">
//             <img src={data.background_image} alt={data.name} />
//           </div>
//           <div className="box-name">
//             <h2>{data.name}</h2>
//           </div>
//           <div className="box-release">
//             <p><b>Release Date: </b> {data.released}</p>
//           </div>
//           <div className="box-rating">
//             <p><b>Rating: </b> {data.rating}/5</p>
//           </div>
//           <div className="box-button">
//             <div className="button-container">
//               {/* Add button to add the game to the WishList */}
//               <button onClick={() => handleButtonAddWishList(data)}>Add to WishList</button>

//               {/* Add button to add the game to the OwnedList */}
//               <button onClick={() => handleButtonAddOwnedList(data)}>Add to OwnedList</button>
//             </div>
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// }

// export default GameDetail;
