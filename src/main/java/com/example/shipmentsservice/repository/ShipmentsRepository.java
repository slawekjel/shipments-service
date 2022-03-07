package com.example.shipmentsservice.repository;

import com.example.shipmentsservice.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentsRepository extends JpaRepository<Shipment, Long> {
}
