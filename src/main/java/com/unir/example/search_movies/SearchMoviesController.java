package com.unir.example.search_movies;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SearchMoviesController {

    @Value("${bonsai.url}")
    private String bonsaiUrl;

    @GetMapping("/peliculas/_search")
    public ResponseEntity<String> searchMovies(@RequestParam String query) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.setBasicAuth("ekja2aceyv", "8a9olb6jho");
        String requestJson = "{ \"query\": { \"term\": { \"Title\": \"" + query + "\" } } }";
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                bonsaiUrl,
                HttpMethod.POST,
                entity,
                String.class
        );

        return response;
    }
}