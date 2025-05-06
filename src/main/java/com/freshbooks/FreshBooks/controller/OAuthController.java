package com.freshbooks.FreshBooks.controller;

import com.freshbooks.FreshBooks.service.FreshBooksOAuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class OAuthController {

    private final FreshBooksOAuthService freshBooksOAuthService;

    public OAuthController(FreshBooksOAuthService freshBooksOAuthService) {
        this.freshBooksOAuthService = freshBooksOAuthService;
    }

    /**
     * Handle FreshBooks OAuth callback
     */
    @GetMapping("/oauth/callback")
    public String handleOAuthCallback(@RequestParam("code") String authorizationCode) {
        // Exchange the authorization code for an access token
        String accessToken = freshBooksOAuthService.getAccessToken(authorizationCode);

        // Store the access token in a secure place (e.g., session, database)
        // In this example, it's returned as a view, you can adjust it to your needs
        return "redirect:/invoice/create?access_token=" + accessToken;
    }
}
