import React, { useState, useEffect } from "react";


function GameVideo() {
  const [videoUrls, setVideoUrls] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const fetchVideoForRandomGames = async () => {
    try {
      const maxRetries = 10;
      const numVideosToFetch = 1;
      const fetchedVideos = [];
      

      for (let i = 0; i < numVideosToFetch; i++) {
        let videoUrl = null;
        let retries = maxRetries;
        

        while (!videoUrl && retries > 0) {
          const randomGameId = Math.floor(Math.random() * 400000) + 1; // Generate a random game ID
          const gameAPI = `http://localhost:7098/game/video/${randomGameId}`;
          const videoResponse = await fetch(gameAPI);

          if (videoResponse.ok) {
            const videoData = await videoResponse.json();

            if (videoData.results && videoData.results.length > 0) {
              const firstVideo = videoData.results[0];
                
              if (firstVideo.data && firstVideo.data.max) {
                videoUrl = firstVideo.data.max;
              }
            }
          }

          retries--;
        }

        fetchedVideos.push(videoUrl);
      }

      setVideoUrls(fetchedVideos);
      setLoading(false);
    } catch (error) {
      setError(error);
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchVideoForRandomGames();
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }

  if (error) {
    return <p>Error: {error.message}</p>;
  }

  return (
    <div className="body-video">

    
    <div className="container-video">
      {videoUrls.map((videoUrl, index) => (
        
        <div className={`video-item video-${index + 1}`} key={index}>
          <iframe
            title={`Random Game Video ${index + 1}`}
            width="100%"
            height="100%"
            src={videoUrl}
            frameBorder="0"
            allowFullScreen
          ></iframe>
        </div>
      ))}
    </div>
    </div>
  );
}

export default GameVideo;


