package com.examu.upaxrest.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birthdate")
    private Date birthdate;
    @OneToOne
    @JoinColumn(name = "job_id")
    private Job job;
    @OneToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;
}
