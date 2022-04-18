package com.example.a12recyclerview01;

/**
 * 水果类
 */
public class Fruit {
    private String fruitName;
    private int fruitImageId;
    private int price;

    public Fruit(String fruitName, int fruitImageId, int price) {
        this.fruitName = fruitName;
        this.fruitImageId = fruitImageId;
        this.price = price;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getFruitImageId() {
        return fruitImageId;
    }

    public void setFruitImageId(int fruitImageId) {
        this.fruitImageId = fruitImageId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
