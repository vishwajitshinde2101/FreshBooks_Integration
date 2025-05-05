package com.freshbooks.FreshBooks.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoiceRequest {

//    @NotBlank
    private String customerId;

//    @NotBlank
    private String createDate;

    private List<InvoiceLineDTO> lines;
}
