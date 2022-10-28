package ua.bg.zooshop.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
    @Id
    private String id;
    @Schema(description = "Link to basket")
    private Basket basket;
    private boolean status;

    public Order() {
    }
    public Order(Order order) {
        id = order.id;
        basket = order.basket;
        status = order.status;
    }

    public Order(String id, Basket basket, boolean status) {
        this.id = id;
        this.basket = basket;
        this.status = status;
    }

    public Order(Basket basket, boolean status) {
        this.basket = basket;
        this.status = status;
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
}
