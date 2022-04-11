package com.example.a12gridview;

/**
 * 描述每一个Item信息
 */
public class ItemInfo {
    private String name;
    private int imgId;

    public ItemInfo(String name, int imgId) {
        this.name = name;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
