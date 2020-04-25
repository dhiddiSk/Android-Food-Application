package com.example.youcare.appbody;

public class Product {

    private String productName;
    private String producerName;
    private String vegan;
    private String vegetarian;
    private String glutenfree;
    private String laktofree;
    private String environment;
    private String	fairSocialPrice;
    private String price;
    private String productImageUrl;

    public Product(String productName, String producerName, String vegan, String vegetarian,
                   String glutenfree, String laktofree, String environment, String fairSocial,String price,String productImageUrl) {
        this.productName = productName;
        this.producerName = producerName;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
        this.glutenfree = glutenfree;
        this.laktofree = laktofree;
        this.environment = environment;
        this.fairSocialPrice = fairSocial;
        this.price = price;
        this.productImageUrl = productImageUrl;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getVegan() {
        return vegan;
    }

    public void setVegan(String vegan) {
        this.vegan = vegan;
    }

    public String getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(String vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String getGlutenfree() {
        return glutenfree;
    }

    public void setGlutenfree(String glutenfree) {
        this.glutenfree = glutenfree;
    }

    public String getLaktofree() {
        return laktofree;
    }

    public void setLaktofree(String laktofree) {
        this.laktofree = laktofree;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getFairSocialPrice() {
        return fairSocialPrice;
    }

    public void setFairSocialPrice(String fairSocialPrice) {
        this.fairSocialPrice = fairSocialPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }
}
