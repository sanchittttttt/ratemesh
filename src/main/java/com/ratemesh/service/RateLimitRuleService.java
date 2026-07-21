package com.ratemesh.service;

import com.ratemesh.model.RateLimitRule;
import com.ratemesh.repository.RateLimitRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateLimitRuleService implements IRateLimitService
{
    @Override
    public String check(String apiKey, String endpoint) {
        return "allowed";
    }
}
