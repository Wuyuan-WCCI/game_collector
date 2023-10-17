import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import '../components/ListPage.css'

const OwnedList = () => {
  const [collection, setCollection] = useState([]);
  
  const authToken = localStorage.getItem('authToken');
  const localUsername = localStorage.getItem('userName');
  
 
  const fetchOwnedListData = async () => {
    if (authToken) {
      const localUserId = localStorage.getItem('userId');
      const baseUrl = `http://localhost:7098/user/${localUserId}/ownedlist`;
      try {
        const response = await fetch(baseUrl, { // Fixed the options format here
          method: 'GET',
          headers: {
            'Authorization': `Bearer ${authToken}`,
          },
        });
  
        if (!response.ok) {
          throw new Error('Response is not right');
        }
  
        const dataText = await response.text();
        console.log('Response text:', dataText);
        const data = JSON.parse(dataText);
        setCollection(data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    }
  }
  
  useEffect(() => {
    
    fetchOwnedListData();
  }, []); 

  console.log("OwnedGames: " + collection);

  return (
    <div>
      <h1 style={{color: 'orange'}}>{localUsername + "'s"} Owned List</h1>
      <div className="list-container">
        {collection.map((item) => (
          <Link to={`/game-detail/${item.game.id}`} key={item.id}>
          <div  className="container-box" key={item.id}>
          <div style={{display: 'block', padding: '20px'}}>
            <div>
            <img
              src={item.game.imgUrl}
              alt={`Image ${item.name}`}
              className="container-box-img"
            />
            </div>
            
            </div>
            <div className="container-font">
            <p><b>Title: {item.game.name}</b></p>
            
            <p>Released: {item.game.released}</p>
            </div>
           
           
          </div>
          </Link>
        ))}
      </div>
    </div>
  );
};

export default OwnedList;
