package com.example.demo.repository;

import com.example.demo.entity.TelemetryEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelemetryEventRepository extends JpaRepository<TelemetryEvent, Long> {
    // By simply extending JpaRepository, Spring automatically generates
    // methods like .save(), .findAll(), .findById() for us. Zero SQL required!
}