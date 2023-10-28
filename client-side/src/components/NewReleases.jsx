
import  { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import Slider from 'react-slick'; // Import the Slider component
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import './Carousel.css'; 
import PropTypes from 'prop-types';

function SampleNextArrow(props) {
  const { className, style, onClick } = props;
  return (
    <div
      className={`${className} carousel-arrow-right`}
      style={{ ...style, display: "block"}}
      onClick={onClick}
    />
  );
}

function SamplePrevArrow(props) {
  const { className, style, onClick } = props;
  return (
    <div
      className={`${className} carousel-arrow-left`}
      style={{ ...style, display:"block" }}
      onClick={onClick}
    />
    
  );
}

SamplePrevArrow.propTypes = {
  className: PropTypes.string,
  style: PropTypes.object, // Validate style as an object
  onClick: PropTypes.func, // Validate onClick as a function
};
SampleNextArrow.propTypes = {
  className: PropTypes.string,
  style: PropTypes.object, // Validate style as an object
  onClick: PropTypes.func, // Validate onClick as a function
};


function NewReleases() {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
   // Define the URL of your backend API
    const apiUrl = 'http://localhost:7098/game/new_games';

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

  // Configure settings for the carousel
  const settings = {
    dots: false,
    infinite: false,
    speed: 1000,
    slidesToShow: 5, // Number of games to show at once
    slidesToScroll: 1,
    waitForAnimate: false,
    
    
    
  
    nextArrow: <SampleNextArrow />,
    prevArrow: <SamplePrevArrow /> 
  };
  

  if (loading) {
    return <p>Loading...</p>;
  }

  if (error) {
    return <p>Error: {error.message}</p>;
  }

  return (
    <div className="carousel-container">
      <div>
      <h2 style={{color: 'yellow'}}>New Released Games</h2>
      </div>
    
      <Slider {...settings}>
        {data.map((game) => (
          <Link to={`/game-detail/${game.id}`} key={game.id}>
          <div >
          <div style={{display: 'block', padding: '20px'}}>
              <div>
                <img src={game.background_image} alt={game.name} className="carousel-item-img" />
              </div>
              <div style={{display: 'block'}}>
                <h2 className="carousel-name">{game.name}</h2>
              </div>
              <div style={{color:'skyblue'}}>
                <p >Released Date: <br/> 
                {game.released}</p> 
                
              </div>
              
              {/* ... Other content ... */}
            </div>
          </div>
          </Link>
        ))}
      </Slider>
    </div>
    
  );
}

export default NewReleases;
