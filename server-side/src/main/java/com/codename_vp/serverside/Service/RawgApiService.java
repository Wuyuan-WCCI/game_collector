package com.codename_vp.serverside.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codename_vp.serverside.Entity.OwnedList;
import com.codename_vp.serverside.Entity.Platform;
import com.codename_vp.serverside.Entity.WishList;
import com.codename_vp.serverside.Repository.PlatformRepo;
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
    private PlatformRepo platformRepo;

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
        String url = apiUrl + "/games?key=" + apiKey + "&ordering=-rating&page_size=10&metacritic=100";

        return restTemplate.getForEntity(url, String.class);
    }

    public ResponseEntity<String> getTrailerVideo(int gameId) {
        String url = apiUrl + "/games/" + gameId + "/movies?key=" + apiKey;
        return restTemplate.getForEntity(url, String.class);
    }

    public ResponseEntity<String> getNewReleaseGames() {
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.toString();

        // Construct the "dates" parameter with the start and end date
        String dateRange = "2023-09-01" + "," + formattedDate;

        // Construct the URL with the "dates" parameter
        String url = apiUrl + "/games?key=" + apiKey + "&ordering=-added&page_size=20&dates=" + dateRange;

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

                OwnedList ownedList = new OwnedList();

                ownedList.setId(jsonNode.get("id").asInt());
                ownedList.setName(jsonNode.get("name").asText());
                ownedList.setSlug(jsonNode.get("slug").asText());
                ownedList.setStatus("Owned");
                ownedList.setOfficialSite(jsonNode.get("website").asText());
                ownedList.setDescription(jsonNode.get("description").asText());
                ownedList.setReleased(jsonNode.get("released").asText());
                ownedList.setImgUrl(jsonNode.get("background_image").asText());

                Set<Platform> platformSet = new HashSet<>();
                JsonNode platformsNode = jsonNode.get("platforms");
                if (platformsNode != null && platformsNode.isArray()) {
                    for (JsonNode platformInfo : platformsNode) {
                        JsonNode platformNode = platformInfo.get("platform");

                        if (platformNode != null) {
                            Platform platform = new Platform();
                            platform.setPlatformId(platformNode.get("id").asInt());
                            platform.setPlatformName(platformNode.get("name").asText());
                            platform.setSlug(platformNode.get("slug").asText());

                            platformSet.add(platform);
                            this.platformRepo.save(platform);

                        }
                    }
                }
                ownedList.setPlatforms(platformSet);
                this.ownedListService.addToOwnedList(ownedList);
                System.out.println("You added game " + ownedList.getName() + " to owned list ");

                return ownedList;

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

                // Add platforms to the wish list
                Set<Platform> platformSet = new HashSet<>();
                JsonNode platformsNode = jsonNode.get("platforms");
                if (platformsNode != null && platformsNode.isArray()) {
                    for (JsonNode platformInfo : platformsNode) {
                        JsonNode platformNode = platformInfo.get("platform");

                        if (platformNode != null) {
                            Platform platform = new Platform();
                            platform.setPlatformId(platformNode.get("id").asInt());
                            platform.setPlatformName(platformNode.get("name").asText());
                            platform.setSlug(platformNode.get("slug").asText());

                            platformSet.add(platform);
                            this.platformRepo.save(platform);
                        }
                    }
                }
                wishList.setPlatforms(platformSet);
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