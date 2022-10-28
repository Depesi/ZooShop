package ua.bg.zooshop.entity;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class Role {
    @Id
    private Integer id;

    private ERole name;

    public enum ERole {
        ROLE_USER,
        ROLE_ADMIN
    }

    public Role(Integer id, ERole name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
