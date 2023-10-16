import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
const OwnedList = () => {
  const [collection, setCollection] = useState([]);
  const baseUrl = 'http://localhost:7098/owned-list';

  const fetchWishListData = async () => {
    try {
      const response = await fetch(baseUrl);
      if (!response.ok) {
        throw new Error('Response is not right');
      }
      const dataText = await response.text(); // Read the raw text
      console.log('Response text:', dataText); // Log the response text
      const data = JSON.parse(dataText); // Attempt to parse the JSON
      setCollection(data);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  }

  useEffect(() => {
    // Call the fetchWishListData function
    fetchWishListData();
  }, []); // Empty dependency array to run this effect only once

  console.log("OwnedGames: " + collection);

  return (
    <div>
      <h1>Owned List</h1>
      <div className="container">
        {collection.map((item) => (
          <Link to={`/game-detail/${item.id}`} key={item.id}>
          <div className="box" key={item.id}>
          <div className="box-image">
            <img
              src={item.game.imgUrl}
              alt={`Image ${item.name}`}
            />
            </div>
            <h3>Title: {item.game.name}</h3>
            <p>Slug: {item.game.slug}</p>
            <p>Released: {item.game.release}</p>
            <p>Description: {item.game.description}</p>
            {/* Add more item details as needed */}
          </div>
          </Link>
        ))}
      </div>
    </div>
  );
};

export default OwnedList;
