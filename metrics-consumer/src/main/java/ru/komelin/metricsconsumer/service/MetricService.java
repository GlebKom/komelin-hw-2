package ru.komelin.metricsconsumer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.komelin.metricsconsumer.model.Metric;
import ru.komelin.metricsconsumer.model.dto.MetricDto;
import ru.komelin.metricsconsumer.repository.MetricRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MetricService {

    private final MetricRepository metricRepository;
    public List<MetricDto> getAllMetrics() {
        return metricRepository.findAll().stream()
                .map(this::metricToMetricDto)
                .collect(Collectors.toList());
    }

    public MetricDto getMetric(Long id) {
        Metric metric = metricRepository.getReferenceById(id);
        return metricToMetricDto(metric);
    }

    // Да, для таких кейсов обычно пишут мапперы, но не думаю, что тут стоит заморачиваться
    private MetricDto metricToMetricDto(Metric metric) {
        return MetricDto.builder()
                .avgRuntime(metric.getAvgRuntime())
                .longestRuntime(metric.getLongestRuntime())
                .exceptionsOccurred(metric.getExceptionsOccurred())
                .methodName(metric.getMethodName())
                .id(metric.getId())
                .build();
    }
}
