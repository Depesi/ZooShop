package ua.bg.zooshop.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "item")
@Data
public class Item {
    @Id
    private String id;
    private String name;
    private int price;
    private int quantity;
    @Schema(description = "The field is used to relate the 'Item' to the animal")
    private String nameForAnimal;
    @Schema(description = "The field indicates the id of the Category")
    @DBRef
    private List<Category> CategoryList;
    private String description;
    @Schema(description = "Should contain a picture")
    private int image;
    @Schema(description = "Number of such items available")
    private int size;

    public Item(String id, String name, int price, int quantity, String nameForAnimal, List<Category> idCategory,
                String description, int image, int size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.nameForAnimal = nameForAnimal;
        this.CategoryList = idCategory;
        this.description = description;
        this.image = image;
        this.size = size;
    }

    public Item(String name, int price, int quantity, String nameForAnimal, List<Category> idCategory,
                String description, int image, int size) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.nameForAnimal = nameForAnimal;
        this.CategoryList = idCategory;
        this.description = description;
        this.image = image;
        this.size = size;
    }

    public Item() {
    }
    public Item(Item item) {
        id = item.id;
        name = item.name;
        price = item.price;
        quantity = item.quantity;
        nameForAnimal = item.nameForAnimal;
        CategoryList = item.CategoryList;
        description = item.description;
        image = item.image;
        size = item.size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNameForAnimal() {
        return nameForAnimal;
    }

    public void setNameForAnimal(String nameForAnimal) {
        this.nameForAnimal = nameForAnimal;
    }

    public List<Category> getCategoryList() {
        return CategoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.CategoryList = categoryList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
