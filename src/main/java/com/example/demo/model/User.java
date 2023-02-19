package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "user_info")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private int mobile;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    @JsonIgnoreProperties("children")
    private User parent;

    @JsonManagedReference
    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnoreProperties("parent")
    private List<User> children;
}
