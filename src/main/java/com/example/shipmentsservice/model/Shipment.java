package com.example.shipmentsservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "SHIPMENTS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Shipment extends BaseEntity {

    private String companyName;
    private String methodName;
    private Double price;
    private String trackingUrl;
    private LocalDate deliveryDate;
}
