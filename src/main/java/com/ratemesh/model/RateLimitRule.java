package com.ratemesh.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RateLimitRule
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String endpoint;
    private int maxRequests;
    private int windowSeconds;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
