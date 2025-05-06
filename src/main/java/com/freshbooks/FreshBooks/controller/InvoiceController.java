package com.freshbooks.FreshBooks.controller;

import com.freshbooks.FreshBooks.Request.CustomOrderRequest;
import com.freshbooks.FreshBooks.service.FreshBooksInvoiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    private final FreshBooksInvoiceService invoiceService;

    public InvoiceController(FreshBooksInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/custom-create")
    public ResponseEntity<String> createInvoiceFromCustomRequest(@Valid @RequestBody CustomOrderRequest request) throws Exception {
        String invoiceResponse = invoiceService.createInvoiceFromCustomRequest(request);
        return ResponseEntity.ok(invoiceResponse);
    }
}
