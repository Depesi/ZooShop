package ua.bg.zooshop.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Basket {
    @Id
    private String id;
    @Schema(description = "Link to User who own that basket")
    @DBRef
    private User user;
    @Schema(description = "List of Items in basket")
    @DBRef
    private List<Item> itemList;
    @Schema(description = "The final price that will be automatically calculated")
    private int totalPrice;

    public Basket() {
    }
    public Basket(Basket basket) {
        id = basket.id;
        user = basket.user;
        itemList = basket.itemList;
        totalPrice = basket.totalPrice;
    }

    public Basket(String id, User user, List<Item> itemList, int totalPrice) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
