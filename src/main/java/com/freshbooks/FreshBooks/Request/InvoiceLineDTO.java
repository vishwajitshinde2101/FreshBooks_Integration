package com.freshbooks.FreshBooks.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;



public class InvoiceLineDTO {

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal unitCost;

    @NotNull
    private Integer quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public InvoiceLineDTO(String name, BigDecimal unitCost, Integer quantity) {
        this.name = name;
        this.unitCost = unitCost;
        this.quantity = quantity;
    }

    public InvoiceLineDTO() {
    }
}
