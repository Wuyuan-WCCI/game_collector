import { useState } from 'react';
import axios from 'axios';
import PropTypes from 'prop-types';

function AddToListButton({ gameId, userId,authToken, actionType }) {
  const [isAdded, setIsAdded] = useState(false);
  const baseUrl = 'http://localhost:7098';

  const handleAction = () => {
    console.log('user id:' + userId + "game id: " + gameId + "authToken: " + authToken)
    const endpoint =
      actionType === 'addToWishList'
        ? `${baseUrl}/user/add-to-wish-list/${gameId}?userId=${userId}`
        : `${baseUrl}/user/add-to-owned-list/${gameId}?userId=${userId}`;

    // Make an API request to add the game to the corresponding list
    axios
    .post(endpoint, {}, {
        headers: {
          'Authorization': `Bearer ${authToken}`,
        },
      })
      .then((response) => {
        if (response.status === 200) {
          setIsAdded(true);
          console.log("Response ok")
        }
      })
      .catch((error) => {
        console.error(error);
        console.log("No Response")
      });
  }

  return (
    <div>
      {isAdded ? (
        <p>Added to {actionType === 'addToWishList' ? 'WishList' : 'OwnedList'}</p>
      ) : (
        <button onClick={handleAction}>
          Add to {actionType === 'addToWishList' ? 'Wish List' : 'OwnedList'}
        </button>
      )}
    </div>
  );
}

AddToListButton.propTypes = {
  gameId: PropTypes.number.isRequired,
  userId: PropTypes.string.isRequired,
  authToken: PropTypes.string.isRequired,
  actionType: PropTypes.oneOf(['addToWishList', 'addToOwnedList']).isRequired,
};

export default AddToListButton;
