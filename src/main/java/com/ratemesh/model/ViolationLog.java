package com.ratemesh.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class ViolationLog
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    private String endpoint;
    private LocalDateTime timeStamp;

    @PrePersist
    public void onCreate()
    {
        timeStamp = LocalDateTime.now();
    }
}
