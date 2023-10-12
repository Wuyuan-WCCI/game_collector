// src/components/SearchBar.js

import React, { useState } from 'react';
import PropTypes from 'prop-types';

import { useNavigate } from 'react-router-dom';
import './SearchBar.css';


function SearchBar({onSearch}) {
  const [query, setQuery] = useState('');
 const navigate = useNavigate();

  const handleSearch = () => {
    onSearch(query);
    
    navigate(`/search-results?query=${encodeURIComponent(query)}`);
    
  };

  const handleKeyPress = (e) => {
    if (e.key === 'Enter') {
      handleSearch();
    }
  };

  return (
    <div className="search-bar-container">
      <input
        type="text"
        placeholder="Search for a game..."
        value={query}
        onChange={(e) => setQuery(e.target.value)}
        onKeyPress={handleKeyPress}
      />
      <button onClick={handleSearch}>Search</button>
      
    </div>
  );
}

SearchBar.propTypes = {
  onSearch: PropTypes.func.isRequired,
};


export default SearchBar;

