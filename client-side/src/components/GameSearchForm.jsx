import { useState } from 'react';
import PropTypes from 'prop-types';

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
// Add prop validation
GameSearchForm.propTypes = {
  onSearch: PropTypes.func.any,
};
export default GameSearchForm;
