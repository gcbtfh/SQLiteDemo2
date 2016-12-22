package com.example.tonghung.sqlitedemo2.object;

/**
 * Created by tonghung on 22/12/2016.
 */

public class Item {
    private int id;
    private String type;
    private String title;
    private String desc;
    private int price;

    public Item() {
    }

    public Item(int id, String type, String title, String desc, int price) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.desc = desc;
        this.price = price;
    }

    public Item(String type, String title, String desc, int price) {
        this.type = type;
        this.title = title;
        this.desc = desc;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                '}';
    }
}
