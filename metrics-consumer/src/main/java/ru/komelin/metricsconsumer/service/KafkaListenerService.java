package ru.komelin.metricsconsumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.komelin.metricsconsumer.model.Metric;
import ru.komelin.metricsconsumer.repository.MetricRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaListenerService {

    private final MetricRepository metricRepository;
    @KafkaListener(id = "metricsGroup", topics = "metrics-topic")
    public void listen(Metric metric) {
        log.info("Received metric message.");
        metricRepository.save(metric);
    }
}
