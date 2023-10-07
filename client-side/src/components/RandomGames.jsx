import { useState, useEffect } from 'react';

function RandomGames() {
  const [randomGames, setRandomGames] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const MAX_RETRIES = 3; // Maximum number of retries for fetching a game

  useEffect(() => {
    // Define the URL of your backend API to fetch random games
    const apiUrl = 'http://localhost:7098/game-detail'; // Adjust the API endpoint as needed

    // Generate 10 random gameIds between 1 and 1000 (adjust the range as needed)
    const getRandomGameId = () => Math.floor(Math.random() * 1000) + 1;

    // Create an array to store the fetched games
    const fetchedGames = [];

    // Function to fetch a game with retries
    const fetchGameWithRetry = async (gameId, retries) => {
      try {
        const response = await fetch(`${apiUrl}/${gameId}`);
        if (!response.ok) {
          throw new Error(`Network response was not ok for gameId ${gameId}`);
        }
        const game = await response.json();
        // Ensure the response is an object with game data
        if (game.id) {
          fetchedGames.push(game);
        } else {
          // Handle cases where the response is unexpected
          throw new Error(`Unexpected API response for gameId ${gameId}`);
        }
      } catch (error) {
        // Retry fetching with a new random gameId if retries remain
        if (retries > 0) {
          const newGameId = getRandomGameId();
          console.warn(`Retrying with a new random gameId: ${newGameId}`);
          await fetchGameWithRetry(newGameId, retries - 1);
        } else {
          // No more retries, mark the game as not found
          fetchedGames.push({ id: gameId, name: 'Game Not Found', description: 'Game not found for this ID.' });
        }
      }
    };

    // Fetch details for each random gameId
    const fetchGames = async () => {
      try {
        for (let i = 0; i < 5; i++) {
          const randomGameId = getRandomGameId();
          await fetchGameWithRetry(randomGameId, MAX_RETRIES);
        }
        setRandomGames(fetchedGames);
        setLoading(false);
      } catch (error) {
        setError(error);
        setLoading(false);
      }
    };

    fetchGames();
  }, []);

  if (loading) {
    return <p>Loading...</p>; // You can show a loading indicator here
  }

  if (error) {
    return <p>Error: {error.message}</p>; // Handle the error here
  }

  return (
    <div>
      <h1 style={{color: 'gold'}}>Random Games</h1>
      <div className="container">
        {randomGames.map((game) => (
          <div className="box" key={game.id}>
          <div className='box-discover-name'>
            <h3>{game.name}</h3>
            </div>
          <div className='box-discover-image'>
          <img
              src={game.background_image}
              alt={`Image ${game.name}`}
            /></div>

            <div className='box-discover-description'>
            {/* <h5>Description:</h5> */}
            <div dangerouslySetInnerHTML={{ __html: game.description }} />
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default RandomGames;
