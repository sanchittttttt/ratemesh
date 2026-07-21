package com.ratemesh.service;

public interface IRateLimitService
{
    public String check(String apiKey, String endpoint);
}

