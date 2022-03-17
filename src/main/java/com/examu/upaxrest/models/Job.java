package com.examu.upaxrest.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "jobs")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double salary;
}
