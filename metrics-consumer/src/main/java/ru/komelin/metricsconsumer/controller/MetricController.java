package ru.komelin.metricsconsumer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.komelin.metricsconsumer.model.dto.MetricDto;
import ru.komelin.metricsconsumer.service.MetricService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MetricController {

    private final MetricService metricService;

    @GetMapping("/metrics")
    public ResponseEntity<?> getAllMetrics() {
        List<MetricDto> metrics = metricService.getAllMetrics();
        return ResponseEntity.ok(metrics);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<?> getMetric(@PathVariable("id") Long id) {
        MetricDto metric = metricService.getMetric(id);
        return ResponseEntity.ok(metric);
    }
}
