package com.online.assistance.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    public Integer getId() {
        return id;
    }

    public Role() { }

    public Role(String name) {
        this.name = name;
    }

    public Role(Integer id) {
        super();
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

