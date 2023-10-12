import React, { useState, useEffect } from 'react';
import axios from 'axios';
import PropTypes from 'prop-types';
import { useLocation } from 'react-router-dom';
import { useSearchParams } from 'react-router-dom';

function SearchResults( ) {
  const [searchResults, setSearchResults] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  
  const [searchParams] = useSearchParams();
  const query = searchParams.get('query');

  useEffect(() => {
    
    console.log("Query: "+ query);
    if (query) {
      setLoading(true); // Set loading to true before making the API request.
      setError(null); // Reset error state.

      axios.get(`http://localhost:7098/game/search?query=${query}`)
        .then((response) => {
          setSearchResults(response.data.results);
        })
        .catch((error) => {
          setError(error); // Set error state if the request fails.
        })
        .finally(() => {
          setLoading(false); // Set loading to false after the request, regardless of success or failure.
        });
    }
  }, [query]);

  return (
    <div>
      <h2 style={{ color: 'gold' }}>Search Results</h2>
      {loading ? (
        <p>Loading...</p>
      ) : error ? (
        <p>Error: {error.message}</p>
      ) : (
        <ul>
  {searchResults.map((result) => (
    <li key={result.id}>
      <p style={{ color: 'white' }}>{result.name}</p>
    </li>
  ))}
</ul>
      )}
    </div>
  );
}

SearchResults.propTypes = {
  query: PropTypes.string,
};

export default SearchResults;

