package com.freshbooks.FreshBooks.controller;

import com.freshbooks.FreshBooks.Request.CreateInvoiceRequest;
import com.freshbooks.FreshBooks.service.FreshBooksInvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final FreshBooksInvoiceService invoiceService;

    @PostMapping("/create")
    public ResponseEntity<String> createInvoice(@Valid @RequestBody CreateInvoiceRequest request) throws Exception {
        return ResponseEntity.ok(invoiceService.createInvoice(request));
    }
}
