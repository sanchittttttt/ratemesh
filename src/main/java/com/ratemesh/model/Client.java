package com.ratemesh.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity //shoot an sql query to create the table dafault name = class name
//@Table("Specify Name")
@Data
public class Client
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String apiKey;
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate()
    {
        createdAt = LocalDateTime.now();
    }
}
