package ua.bg.zooshop.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

enum Role {
    USER,
    ADMIN,
    CUSTOMER
}
@Document
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private int phone;
    private String firstName;
    private String lastName;
    private String surrName;
    private String email;
    @Schema(description = "Discount for this user")
    private int discount;
    private Role role;

    public User(String id, String username, String password, int phone, String firstName,
                String lastName, String surrName, String email, int discount, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surrName = surrName;
        this.email = email;
        this.discount = discount;
        this.role = role;
    }

    public User(String username, String password, int phone, String firstName, String lastName,
                String surrName, String email, int discount, Role role) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surrName = surrName;
        this.email = email;
        this.discount = discount;
        this.role = role;
    }

    public User() {
    }

    public User(User newUser) {
        id = newUser.id;
        username = newUser.username;
        password = newUser.password;
        phone = newUser.phone;
        firstName = newUser.firstName;
        lastName = newUser.lastName;
        surrName = newUser.surrName;
        email = newUser.email;
        discount = newUser.discount;
        role = newUser.role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurrName() {
        return surrName;
    }

    public void setSurrName(String surrName) {
        this.surrName = surrName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
