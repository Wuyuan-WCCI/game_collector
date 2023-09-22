import { useState, useEffect } from "react";

const WishList = () => {
    const [collection, setCollection] = useState([]);
    const baseUrl = 'http://localhost:7098/wish-list';

    useEffect(() => {
        const fetchWishListData = async () => {
          try {
            const response = await fetch(baseUrl);
            if (!response.ok) {
              throw new Error('Response is not right');
            }
            const data = await response.json();
            setCollection(data);
          } catch (error) {
            console.error('Error fetching data:', error);
          }
        };
    
        fetchWishListData();
      }, []);
    
      return (
        <div>
          <h1>WishList</h1>
          <ul>
            {collection.map((item) => (
              <li key={item.id}>
                <div>
                  <img
                    src={item.imgUrl}
                    alt={`Image ${item.name}`}
                  />
                  <h3>Title: {item.name}</h3>
                  <p>Slug:{item.slug}</p>
                  <p>Released: {item.release}</p>
                  <p>Description: {item.description}</p>
                </div>
              </li>
            ))}
          </ul>
        </div>
      );



}

export default WishList;