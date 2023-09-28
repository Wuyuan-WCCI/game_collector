import { useEffect, useState } from 'react';

function DiscoverySearch() {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    // Define the URL of your backend API
    const apiUrl = 'http://localhost:7098/top_games';

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
      <h1>HOT GAMES</h1>
      <div className="container">
        {data.map((game) => (
          <div className="box" key={game.id}>
          <img src={game.image_background} alt={game.name} />
            <h2>Title: {game.name}</h2>

            <p><b>Release Date: </b> {game.released}</p>
            <p><b>Rating: </b> {game.rating}/5</p>
            {/* Add more game details as needed */}
          </div>
        ))}
      </div>
    </div>
  );
}

export default DiscoverySearch;
