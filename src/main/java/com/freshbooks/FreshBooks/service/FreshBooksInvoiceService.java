package com.freshbooks.FreshBooks.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freshbooks.FreshBooks.Request.CreateInvoiceRequest;
import com.freshbooks.FreshBooks.Request.InvoiceLineDTO;
import com.freshbooks.FreshBooks.config.FreshBooksConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@RequiredArgsConstructor
public class FreshBooksInvoiceService {

    private final RestTemplate restTemplate;
    private final FreshBooksConfig config;
    private final ObjectMapper objectMapper;

    public String createInvoice(CreateInvoiceRequest request) throws Exception {
        String accessToken = getAccessToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> invoicePayload = new HashMap<>();
        invoicePayload.put("customerid", request.getCustomerId());
        invoicePayload.put("create_date", request.getCreateDate());

        List<Map<String, Object>> lines = new ArrayList<>();
        for (InvoiceLineDTO line : request.getLines()) {
            Map<String, Object> lineItem = new HashMap<>();
            lineItem.put("name", line.getName());
            lineItem.put("unit_cost", Map.of("amount", line.getUnitCost(), "code", "USD"));
            lineItem.put("quantity", line.getQuantity());
            lines.add(lineItem);
        }
        invoicePayload.put("lines", lines);

        Map<String, Object> body = Map.of("invoice", invoicePayload);
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
