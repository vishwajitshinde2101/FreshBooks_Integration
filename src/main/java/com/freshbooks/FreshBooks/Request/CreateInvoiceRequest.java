package com.freshbooks.FreshBooks.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class CreateInvoiceRequest {

    @NotBlank
    private String customerId;

    @NotBlank
    private String createDate;

    private List<InvoiceLineDTO> lines;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<InvoiceLineDTO> getLines() {
        return lines;
    }

    public void setLines(List<InvoiceLineDTO> lines) {
        this.lines = lines;
    }

    public CreateInvoiceRequest() {
    }

    public CreateInvoiceRequest(String customerId, String createDate, List<InvoiceLineDTO> lines) {
        this.customerId = customerId;
        this.createDate = createDate;
        this.lines = lines;
    }
}
