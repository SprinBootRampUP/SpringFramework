package org.example.rampup.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Getter
@Setter
public class Course {



    //////

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    @Basic(optional = false)

    private String title;

    @Column( columnDefinition = "VARCHAR(255) default 'Welcome to my course'")
    private String description;

    private String price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Course(){
        this.createdAt = new Date();
    }











}
