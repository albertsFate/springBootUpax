package com.examu.upaxrest.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "genders")
@Data
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
