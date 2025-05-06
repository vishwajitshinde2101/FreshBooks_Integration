package com.freshbooks.FreshBooks.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freshbooks.FreshBooks.Request.CreateInvoiceRequest;
import com.freshbooks.FreshBooks.Request.CustomOrderRequest;
import com.freshbooks.FreshBooks.Request.InvoiceLineDTO;
import com.freshbooks.FreshBooks.Request.OrderItem;
import com.freshbooks.FreshBooks.config.FreshBooksConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class FreshBooksInvoiceService {

    private final RestTemplate restTemplate;
    private final FreshBooksConfig config;
    private final ObjectMapper objectMapper;

    public FreshBooksInvoiceService(RestTemplate restTemplate, FreshBooksConfig config, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.config = config;
        this.objectMapper = objectMapper;
    }

    public String createInvoiceFromCustomRequest(CustomOrderRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(getAccessToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> invoice = new HashMap<>();
        invoice.put("customerid", "123456"); // Or fetch dynamically
        invoice.put("create_date", request.getOrderDateTime().substring(0, 10)); // ISO date

        List<Map<String, Object>> lines = new ArrayList<>();
        for (OrderItem item : request.getOrder_items()) {
            Map<String, Object> line = new HashMap<>();
            line.put("name", item.getTitle());
            line.put("unit_cost", Map.of("amount", item.getPrice(), "code", "USD"));
            line.put("quantity", item.getQuantity());
            lines.add(line);
        }

        invoice.put("lines", lines);

        Map<String, Object> body = Map.of("invoice", invoice);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                config.getBaseUrl() + "/accounting/account/" + config.getAccountId() + "/invoices/invoices",
                HttpMethod.POST,
                entity,
                String.class
        );

        return response.getBody();
    }

    private String getAccessToken() {
        return "your-access-token";
    }
}
