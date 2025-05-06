package com.freshbooks.FreshBooks.Request;

import lombok.Data;

import java.math.BigDecimal;


public class OrderItem {
    private String title;
    private BigDecimal price;
    private Integer quantity;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderItem(String title, BigDecimal price, Integer quantity) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItem() {
    }




}
