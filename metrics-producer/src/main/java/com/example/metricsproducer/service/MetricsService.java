package com.example.metricsproducer.service;

import com.example.metricsproducer.model.dto.MetricDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MetricsService {

    private final KafkaTemplate<Object, Object> kafkaTemplate;

    public void postMessageToQueue(MetricDto metricDto) {
        if (validateMetricDto(metricDto)) {
            kafkaTemplate.send("metrics-topic", metricDto);
        } else {
            throw new IllegalArgumentException("MetricDto mustn't contain null values.");
        }
    }

    private boolean validateMetricDto(MetricDto metricDto) {
        return metricDto.getAvgRuntime() != null &&
                metricDto.getExceptionsOccurred() != null &&
                metricDto.getMethodName() != null &&
                metricDto.getLongestRuntime() != null;
    }
}
