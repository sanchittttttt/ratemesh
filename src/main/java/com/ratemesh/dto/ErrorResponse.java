package com.ratemesh.advice;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse
{
    private String message;
    private Integer statusCode;
    private LocalDateTime timestamp;
}
