package com.freshbooks.FreshBooks.config;

import lombok.Data;
import lombok.Getter;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;



@Getter
@Component
public class FreshBooksConfig {

    @Value("${freshbooks.client-id}")
    private String clientId;

    @Value("${freshbooks.client-secret}")
    private String clientSecret;

    @Value("${freshbooks.redirect-uri}")
    private String redirectUri;

    @Value("${freshbooks.base-url}")
    private String baseUrl;

    private String authUrl;

    @Value("${freshbooks.account-id}")
    private String accountId;


    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
