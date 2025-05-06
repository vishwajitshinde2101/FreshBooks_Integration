package com.freshbooks.FreshBooks.Request;


import lombok.Data;

import java.math.BigDecimal;


public class OrderPayment {
    private String payment_option;
    private BigDecimal amount;

    public OrderPayment() {
    }

    public String getPayment_option() {
        return payment_option;
    }

    public void setPayment_option(String payment_option) {
        this.payment_option = payment_option;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OrderPayment(String payment_option, BigDecimal amount) {
        this.payment_option = payment_option;
        this.amount = amount;
    }
}
