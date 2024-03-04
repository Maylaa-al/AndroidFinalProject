package com.example.androidfinalproject.ui.Pojo;

public class Budget {

    private int id;
    private Double price;
    private String currency;

    public Budget(int id, Double price, String currency) {
        this.id = id;
        this.price = price;
        this.currency = currency;
    }

    public Budget(Double price, String currency) {
        this.price = price;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
