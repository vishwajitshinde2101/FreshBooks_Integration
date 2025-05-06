package com.freshbooks.FreshBooks.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class FreshBooksOAuthService {

    @Value("${freshbooks.client-id}")
    private String clientId;

    @Value("${freshbooks.client-secret}")
    private String clientSecret;

    @Value("${freshbooks.redirect-uri}")
    private String redirectUri;

    @Value("${freshbooks.auth-url}")
    private String authUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getAccessToken(String authorizationCode) {
        String tokenUrl = "https://api.freshbooks.com/auth/oauth/token";

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("code", authorizationCode);
        map.add("redirect_uri", redirectUri);
        map.add("grant_type", "authorization_code");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.exchange(
            tokenUrl, HttpMethod.POST, entity, String.class);

        // Parse the access token from response
        try {
            JsonNode responseNode = new ObjectMapper().readTree(response.getBody());
            return responseNode.get("access_token").asText();
        } catch (Exception e) {
            throw new RuntimeException("Error extracting access token", e);
        }
    }
}
