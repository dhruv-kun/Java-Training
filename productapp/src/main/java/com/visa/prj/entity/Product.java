package com.visa.prj.entity;

public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int count;
    public Product() {
    }
    public Product(int id, String name, String category, double price, int count) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.count = count;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
