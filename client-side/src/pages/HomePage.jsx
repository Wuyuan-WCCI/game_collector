import React, { useState } from 'react';
import SearchBar from '../components/SearchBar';

const HomePage = () => {

  const [searchQuery, setSearchQuery] = useState('');

  const handleSearch = (query) => {
    setSearchQuery(query);
  };

  return (
    <div className="search-bar">
      <SearchBar onSearch={handleSearch} />
    </div>
  );
};

export default HomePage;


