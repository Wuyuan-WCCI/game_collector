package com.codename_vp.serverside.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codename_vp.serverside.Entity.OwnedList;
import com.codename_vp.serverside.Entity.WishList;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RawgApiService {
    private final String apiUrl = "https://api.rawg.io/api/";
    private final String apiKey = "e2f8a419b56946b08d0b3b532c972af5";

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> getGameDetailById(Long game_id) {

        String url = apiUrl + "/games/" + game_id + "?key=" + apiKey;
        return restTemplate.getForEntity(url, String.class);
    }

    public ResponseEntity<String> searchGameByName(String query) {
        String url = apiUrl + "/games?key=" + apiKey + "&search=" + query;
        return restTemplate.getForEntity(url, String.class);
    }

    public OwnedList addToOwnedList(Long game_id) {
        ResponseEntity<String> response = getGameDetailById(game_id);
        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseBody);
                OwnedList ownedList = new OwnedList();
                ownedList.setId(jsonNode.get("id").asLong());
                ownedList.setName(jsonNode.get("name").asText());
                ownedList.setSlug(jsonNode.get("slug").asText());
                ownedList.setDescription(jsonNode.get("description").asText());
                ownedList.setReleased(jsonNode.get("released").asText());
                ownedList.setImgUrl(jsonNode.get("background_image").asText());
                return ownedList;

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public WishList addToWishList(Long game_id) {
        ResponseEntity<String> response = getGameDetailById(game_id);
        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseBody);
                WishList wishList = new WishList();
                wishList.setId(jsonNode.get("id").asLong());
                wishList.setName(jsonNode.get("name").asText());
                wishList.setSlug(jsonNode.get("slug").asText());
                wishList.setDescription(jsonNode.get("description").asText());
                wishList.setReleased(jsonNode.get("released").asText());
                wishList.setImgUrl(jsonNode.get("background_image").asText());
                return wishList;

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

}
