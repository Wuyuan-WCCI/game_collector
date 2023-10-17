import { useState, useEffect } from 'react';
import axios from 'axios';
import PropTypes from 'prop-types';
import { useSearchParams } from 'react-router-dom';
import './SearchResultsPage.css'
import SearchBar from '../components/SearchBar';
import { Link } from 'react-router-dom';

function SearchResults( ) {
  const [searchResults, setSearchResults] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  
  const [searchParams] = useSearchParams();
  const query = searchParams.get('query');
  const [searchQuery, setSearchQuery] = useState('');

  const handleSearch = (query) => {
    setSearchQuery(query);
  };



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
      <div className="search-bar">
        <SearchBar onSearch={handleSearch} />
      </div>
      <div className="search-results-container">
        <h3 style={{ color: 'gold', marginBottom: '30px', marginTop: '30px'}}>Search Results:</h3>
        {loading ? (
          <p>Loading...</p>
        ) : error ? (
          <p>Error: {error.message}</p>
        ) : (
          <ul className="search-results-list">
            {searchResults.map((result) => (
              
              <Link to={`/game-detail/${result.id}`  }key={result.id}>
              <li className="search-result-item">
              <div className="result-item-content">
                <img src={result.background_image} alt={result.name} className='result-img' 
                />
                <div className="result-text" >
          <p>ID: {result.id}</p>
          
          <p style={{color:'purple'}}><b>{result.name} </b></p>
          <p>Released Date: {result.released}</p>
        </div>
                </div>
              </li>
              </Link>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
}

SearchResults.propTypes = {
  query: PropTypes.string,
};

export default SearchResults;

