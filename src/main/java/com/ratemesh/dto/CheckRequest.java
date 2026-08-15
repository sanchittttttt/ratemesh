package com.ratemesh.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CheckRequest
{
    @NotBlank(message = "apiKey is mandatory")
    private String apiKey;
    @NotBlank(message = "endPoint is mandatory")
    private String endPoint;
}
