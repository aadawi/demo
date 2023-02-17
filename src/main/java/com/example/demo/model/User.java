package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "user_info")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private int mobile;

    @ManyToOne
    @JoinColumn(name = "LEAD_ID")
    private User lead;
}
