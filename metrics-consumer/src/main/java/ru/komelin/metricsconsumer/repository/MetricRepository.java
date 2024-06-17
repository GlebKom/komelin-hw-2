package ru.komelin.metricsconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.komelin.metricsconsumer.model.Metric;

import java.util.List;

public interface MetricRepository extends JpaRepository<Metric, Long> {
    List<Metric> findAll();
}
