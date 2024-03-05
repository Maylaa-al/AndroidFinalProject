package com.example.androidfinalproject.ui.Pojo;

public class Budget {

    private int id;
    private Double price;
    private String fromCurrency;

    private String toCurrency;

    private String date;

    public Budget(int id, Double price, String fromCurrency, String toCurrency, String date) {
        this.id = id;
        this.price = price;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.date = date;
    }

    public Budget(Double price, String fromCurrency, String toCurrency, String date) {
        this.price = price;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
