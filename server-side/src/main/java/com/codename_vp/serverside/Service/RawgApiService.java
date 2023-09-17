package com.codename_vp.serverside.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codename_vp.serverside.Entity.OwnedList;
import com.codename_vp.serverside.Entity.WishList;
import com.codename_vp.serverside.Repository.OwnedListRepo;
import com.codename_vp.serverside.Repository.WishListRepo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RawgApiService {
    private final String apiUrl = "https://api.rawg.io/api/";
    private final String apiKey = "e2f8a419b56946b08d0b3b532c972af5";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WishListRepo wishListRepo;

    @Autowired
    OwnedListService ownedListService;

    @Autowired
    WishListService wishListService;

    public ResponseEntity<String> getGameDetailById(int game_id) {

        String url = apiUrl + "/games/" + game_id + "?key=" + apiKey;
        return restTemplate.getForEntity(url, String.class);
    }

    public ResponseEntity<String> searchGameByName(String query) {
        String url = apiUrl + "/games?key=" + apiKey + "&search=" + query;
        return restTemplate.getForEntity(url, String.class);
    }

    public ResponseEntity<String> getTop10Games() {
        String url = apiUrl + "/games?key=" + apiKey + "&ordering=-rating&page_size=1&metacritic=800";

        return restTemplate.getForEntity(url, String.class);
    }

    public OwnedList addToOwnedList(int gameId) {
        ResponseEntity<String> response = getGameDetailById(gameId);

        wishListService.removeFromWishList(gameId);

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseBody);

                OwnedList gameToAdd = new OwnedList();

                gameToAdd.setId(jsonNode.get("id").asInt());
                gameToAdd.setName(jsonNode.get("name").asText());
                gameToAdd.setSlug(jsonNode.get("slug").asText());
                gameToAdd.setStatus("Owned");
                gameToAdd.setOfficialSite(jsonNode.get("website").asText());
                gameToAdd.setDescription(jsonNode.get("description").asText());
                gameToAdd.setReleased(jsonNode.get("released").asText());
                gameToAdd.setImgUrl(jsonNode.get("background_image").asText());
                this.ownedListService.addToOwnedList(gameToAdd);
                System.out.println("You add game " + gameToAdd.getName() + " to owned list ");
                return gameToAdd;

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public WishList addToWishList(int gameId) {
        ResponseEntity<String> response = getGameDetailById(gameId);
        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseBody);
                WishList wishList = new WishList();
                wishList.setId(jsonNode.get("id").asInt());
                wishList.setName(jsonNode.get("name").asText());
                wishList.setSlug(jsonNode.get("slug").asText());
                wishList.setDescription(jsonNode.get("description").asText());
                wishList.setStatus("Wished");
                wishList.setReleased(jsonNode.get("released").asText());
                wishList.setImgUrl(jsonNode.get("background_image").asText());

                this.wishListRepo.save(wishList);
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
