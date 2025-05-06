package com.freshbooks.FreshBooks.config;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
public class FreshBooksConfig {

    @Value("${freshbooks.client-id}")
    private String clientId;

    @Value("${freshbooks.client-secret}")
    private String clientSecret;

    @Value("${freshbooks.redirect-uri}")
    private String redirectUri;

    @Value("${freshbooks.base-url}")
    private String baseUrl;

    @Value("${freshbooks.auth-url}")
    private String authUrl;

    @Value("${freshbooks.account-id}")
    private String accountId;

    public String getClientId() { return clientId; }
    public String getClientSecret() { return clientSecret; }
    public String getRedirectUri() { return redirectUri; }
    public String getBaseUrl() { return baseUrl; }
    public String getAuthUrl() { return authUrl; }
    public String getAccountId() { return accountId; }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
