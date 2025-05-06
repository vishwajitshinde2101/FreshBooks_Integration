package com.freshbooks.FreshBooks.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceLineDTO {

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal unitCost;

    @NotNull
    private Integer quantity;
}
