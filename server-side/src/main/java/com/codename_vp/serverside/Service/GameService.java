package com.codename_vp.serverside.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codename_vp.serverside.Entity.Game;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;

@Service
public class GameService {

    private final String apiUrl = "https://api.rawg.io/api/games";
    private final String apiKey = "e2f8a419b56946b08d0b3b532c972af5";

    @Autowired
    private RestTemplate restTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    public ResponseEntity<Game> getGames() {
        // Construct the URL dynamically with the provided parameter
        String url = apiUrl + "?key=" + apiKey;

        // Use RestTemplate to fetch data from the external API
        ResponseEntity<Game> response = restTemplate.exchange(url, HttpMethod.GET, null, Game.class);

        // Return the response from the API
        return response;
    }

    public ResponseEntity<String> getAllGamesFromApi() {
        String url = apiUrl + "?key=" + apiKey;
        return restTemplate.getForEntity(url, String.class);
    }

    public List<Game> parseGamesFromJsonString(String jsonString) throws IOException {
        // Use Jackson ObjectMapper to parse JSON response into a list of Game objects
        return objectMapper.readValue(jsonString, new TypeReference<List<Game>>() {
        });
    }
}
