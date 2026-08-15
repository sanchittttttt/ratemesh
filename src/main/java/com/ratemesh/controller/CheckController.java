package com.ratemesh.controller;

import com.ratemesh.dto.CheckRequest;
import com.ratemesh.service.RateLimitRuleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController
{
    private RateLimitRuleService service;

    @Autowired
    public CheckController(RateLimitRuleService service)
    {
        this.service = service;
    }

    @PostMapping("/api/check")
    public ResponseEntity<String> check(@Valid @RequestBody CheckRequest checkRequest)
    {
        String apiKey = checkRequest.getApiKey();
        String endPoint = checkRequest.getEndPoint();
        String permission = service.check(apiKey, endPoint);
        return  ResponseEntity.ok(permission);
    }
}
