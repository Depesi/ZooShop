package ua.bg.zooshop.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Basket {
    @Id
    private int id;
    private User user;
    private List<Item> itemList;
    private int totalPrice;

    public Basket() {
    }

    public Basket(int id, User user, List<Item> itemList, int totalPrice) {
        this.id = id;
        this.user = user;
        this.itemList = itemList;
        this.totalPrice = totalPrice;
    }

    public Basket(User user, List<Item> itemList, int totalPrice) {
        this.user = user;
        this.itemList = itemList;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
