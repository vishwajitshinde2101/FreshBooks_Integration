package com.freshbooks.FreshBooks.Request;


import java.util.List;


public class CustomOrderRequest {
    private String order_id;
    private String orderDateTime;
    private List<OrderItem> order_items;
    private List<OrderPayment> order_payments;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public List<OrderItem> getOrder_items() {
        return order_items;
    }

    public void setOrder_items(List<OrderItem> order_items) {
        this.order_items = order_items;
    }

    public List<OrderPayment> getOrder_payments() {
        return order_payments;
    }

    public void setOrder_payments(List<OrderPayment> order_payments) {
        this.order_payments = order_payments;
    }

    public CustomOrderRequest(String order_id, String orderDateTime, List<OrderItem> order_items, List<OrderPayment> order_payments) {
        this.order_id = order_id;
        this.orderDateTime = orderDateTime;
        this.order_items = order_items;
        this.order_payments = order_payments;
    }

    public CustomOrderRequest() {
    }

}
