package com.codename_vp.serverside.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RawgApiService {
    private final String apiUrl = "https://api.rawg.io/api/";
    private final String apiKey = "e2f8a419b56946b08d0b3b532c972af5";

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> getGameDetail(String game_id) {

        String url = apiUrl + "/games/" + game_id + "?key=" + apiKey;
        return restTemplate.getForEntity(url, String.class);
    }

    public ResponseEntity<String> searchGame(String query) {
        String url = apiUrl + "/games?key=" + apiKey + "&search=" + query;
        return restTemplate.getForEntity(url, String.class);
    }

}
