package com.example.metricsproducer.controller;

import com.example.metricsproducer.model.dto.MetricDto;
import com.example.metricsproducer.service.MetricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class MetricsController {
    private final MetricsService metricsService;

    @PostMapping("/metrics")
    public ResponseEntity<?> postMetrics(@RequestBody MetricDto metricsDto) {
        try {
            metricsService.postMessageToQueue(metricsDto);
            return ResponseEntity.ok("Message sent");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body("Invalid metric dto.");
        }
    }
}
