import { useState } from 'react';

function GameSearchForm({ onSearch }) {
  const [gameId, setGameId] = useState('');

  const handleSearch = () => {
    // Call the onSearch function with the entered gameId
    onSearch(gameId);
  };

  return (
    <div>
      <input
        type="text"
        placeholder="Enter Game ID"
        value={gameId}
        onChange={(e) => setGameId(e.target.value)}
      />
      <button onClick={handleSearch}>Search</button>
    </div>
  );
}

export default GameSearchForm;
