import { useState, useEffect } from "react";

const OwnedList = () => {
  const [collection, setCollection] = useState([]);
  const baseUrl = "http://localhost:7098/owned-list";

  const fetchWishListData = async () => {
    try {
      const response = await fetch(baseUrl);
      if (!response.ok) {
        throw new Error("Response is not right");
      }
      const dataText = await response.text(); // Read the raw text
      console.log("Response text:", dataText); // Log the response text
      const data = JSON.parse(dataText); // Attempt to parse the JSON
      setCollection(data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  useEffect(() => {
    // Call the fetchWishListData function
    fetchWishListData();
  }, []); // Empty dependency array to run this effect only once

  console.log("OwnedGames: " + collection);

  return (
    <div className="ownedList">
      <h1>Owned List</h1>
      <div className="container">
        {collection.map((item) => (
          <div className="box" key={item.id}>
            <img src={item.imgUrl} alt={`Image ${item.name}`} />
            <h3>Title: {item.name}</h3>
            <p>Slug: {item.slug}</p>
            <p>Released: {item.release}</p>
            <p>Description: {item.description}</p>
            {/* Add more item details as needed */}
          </div>
        ))}
      </div>
    </div>
  );
};

export default OwnedList;
