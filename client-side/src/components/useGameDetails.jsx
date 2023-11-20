import { useState, useEffect } from 'react';

function useGameDetails(gameId) {
  const [game, setGame] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const apiUrl = `http://localhost:7098/game-detail/${gameId}`;

    // Function to fetch game details
    const fetchGameDetails = async () => {
      try {
        const response = await fetch(apiUrl);
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const gameData = await response.json();
        setGame(gameData);
        setLoading(false);
      } catch (error) {
        setError(error);
        setLoading(false);
      }
    };

    fetchGameDetails();
  }, [gameId]);

  return { game, loading, error };
}

export default useGameDetails;
