package com.example.metricsproducer.model.dto;

import lombok.Data;

@Data
public class MetricDto {
    private String methodName;
    private Double avgRuntime;
    private Long exceptionsOccurred;
    private Long longestRuntime;
}
