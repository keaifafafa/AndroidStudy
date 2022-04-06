package com.example.a11listview02;

/**
 * 用户类
 */
public class User {
    private String name;
    private int imagePathId;

    public User(String name, int imagePath) {
        this.name = name;
        this.imagePathId = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImagePathId() {
        return imagePathId;
    }

    public void setImagePathId(int imagePathId) {
        this.imagePathId = imagePathId;
    }
}
