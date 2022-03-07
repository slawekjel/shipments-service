package com.example.shipmentsservice.controller;

import com.example.shipmentsservice.model.Shipment;
import com.example.shipmentsservice.model.ShipmentRequest;
import com.example.shipmentsservice.service.ShipmentsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/shipments/")
public class ShipmentController {

    private final ShipmentsService shipmentsService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shipment> createShipment(@RequestBody ShipmentRequest shipmentRequest) {
        log.info("Received a request with shipment details to create new shipment.");
        try {
            var shipment = shipmentsService.orderShipment(shipmentRequest);
            return new ResponseEntity<>(shipment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
