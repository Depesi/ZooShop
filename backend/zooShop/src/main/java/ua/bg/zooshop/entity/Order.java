package ua.bg.zooshop.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
    @Id
    private String id;
    @Schema(description = "Link to basket")
    @DBRef
    private Basket basket;
    private boolean status;
    @Schema(description = "Point to delivery")
    private String delivery;
    @Schema(description = "Write another infomation")
    private String description;

    public Order(String id, Basket basket, boolean status, String delivery, String description) {
        this.id = id;
        this.basket = basket;
        this.status = status;
        this.delivery = delivery;
        this.description = description;
    }

    public Order(Basket basket, boolean status, String delivery, String description) {
        this.basket = basket;
        this.status = status;
        this.delivery = delivery;
        this.description = description;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
