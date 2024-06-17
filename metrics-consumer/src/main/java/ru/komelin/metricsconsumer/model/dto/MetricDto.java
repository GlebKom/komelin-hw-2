package ru.komelin.metricsconsumer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MetricDto {
    private Long id;
    private String methodName;
    private Double avgRuntime;
    private Long exceptionsOccurred;
    private Long longestRuntime;
}
