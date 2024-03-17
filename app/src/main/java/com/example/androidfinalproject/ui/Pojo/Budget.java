package com.example.androidfinalproject.ui.Pojo;

import java.util.Date;

/**
 *  POJO/JavaBean to represent some form of data that the app will be built around*/
public class Budget {

    private int id;
    private Double price;
    private String fromCurrency;
    private String toCurrency;
    private String date;
    private String accountNum;
    private String category;
    private double amount;
    private String notes;

// Create object to read from the database
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

    public Budget(int id, String date, String accountNum, String category, double amount, String notes) {
        this.id = id;
        this.date = date;
        this.accountNum = accountNum;
        this.category = category;
        this.amount = amount;
        this.notes = notes;
    }

    public Budget(String date, String accountNum, String category, double amount, String notes) {
        this.date = date;
        this.accountNum = accountNum;
        this.category = category;
        this.amount = amount;
        this.notes = notes;
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

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
