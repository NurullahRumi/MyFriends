package com.example.thymeleafproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_myfriend")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyFriend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phNo;
    private String address;
    private String preAdd;
}
