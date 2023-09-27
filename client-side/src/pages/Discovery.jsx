import { useEffect, useState } from 'react';
import GameList from '../components/GameList';

function DiscoverySearch() {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    // Define the URL of your backend API
    const apiUrl = 'http://localhost:7098/top_games'

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
      <GameList></GameList>
      <ul>
        {data.map((item) => (
          <li key={item.id}>{item.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default DiscoverySearch;
