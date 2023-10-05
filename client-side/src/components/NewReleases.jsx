import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';


function NewReleases() {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);


  // Define your WishList and OwnedList states
  const [wishList, setWishList] = useState([]);
  const [ownedList, setOwnedList] = useState([]);

  // Function to handle adding a game to the WishList
  const handleButtonAddWishList = (game) => {
    // Check if the game is already in the WishList to avoid duplicates
    if (!wishList.some((item) => item.id === game.id)) {
      // Add the game to the WishList
      setWishList([...wishList, game]);
    }
  };

  // Function to handle adding a game to the OwnedList
  const handleButtonAddOwnedList = (game) => {
    // Check if the game is already in the OwnedList to avoid duplicates
    if (!ownedList.some((item) => item.id === game.id)) {
      // Add the game to the OwnedList
      setOwnedList([...ownedList, game]);
    }
  };


  useEffect(() => {
    // Define the URL of your backend API
    const apiUrl = 'http://localhost:7098/new_games';

    fetch(apiUrl)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then((data) => {
        if (data.results && Array.isArray(data.results)) {
          setData(data.results);
          setLoading(false);
        } else {
          // Handle cases where the response structure is unexpected
          setError(new Error('Unexpected API response'));
          setLoading(false);
        }
      })
      .catch((error) => {
        setError(error);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <p>Loading...</p>; // You can show a loading indicator here
  }

  if (error) {
    return <p>Error: {error.message}</p>; // Handle the error here
  }

  return (
    <div>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      {/* <h1>HOT GAMES</h1> */}
      <div>


      {/* ...the rest of your game listing */}
    </div>
    <div className="container">
    {data.map((game) => (
      <Link to={`/game-detail/${game.id}`} key={game.id}>
        <div className="box">
          <div className="box-image">
            <img src={game.background_image} alt={game.name} />
          </div>
          <div className="box-name">
            <h2>{game.name}</h2>
          </div>
          <div className="box-name">
            <h2>{game.description}</h2>
          </div>
          <div className="box-button">
            <h2>{game.id}</h2>
          </div>
          <div className="box-release">
            <p><b>Release Date: </b> {game.released}</p>
          </div>
          <div className="box-rating">
            <p><b>Rating: </b> {game.rating}/5</p>
          </div>
          <div className="box-button">
            <div className="button-container">
              {/* Add button to add the game to the WishList */}
              <button onClick={() => handleButtonAddWishList(game)}>Add to WishList</button>

              {/* Add button to add the game to the OwnedList */}
              <button onClick={() => handleButtonAddOwnedList(game)}>Add to OwnedList</button>
            </div>
          </div>
        </div>
      </Link>
    ))}
  </div>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
    </div>
  );
}

export default NewReleases;
