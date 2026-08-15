package com.ratemesh.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank
    @Size(min = 8, message = "Must be at least 8 characters long")
    private String apiKey;
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate()
    {
        createdAt = LocalDateTime.now();
    }
}
