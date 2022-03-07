package com.example.shipmentsservice.service;

import com.example.shipmentsservice.model.Shipment;
import com.example.shipmentsservice.model.ShipmentRequest;
import com.example.shipmentsservice.repository.ShipmentsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@AllArgsConstructor
public class ShipmentsService {

    private final ShipmentsRepository shipmentsRepository;

    public Shipment orderShipment(ShipmentRequest shipmentRequest) {
        log.info("Ordering a shipment by informing external company and getting details");
        var shipment = informAboutNewShipment(shipmentRequest);
        return createShipment(shipment);
    }

    private Shipment createShipment(Shipment shipment) {
        return shipmentsRepository.save(shipment);
    }

    /*
    Example method which could execute request to endpoint provided by shipment company to inform them about
    new shipment request and get more details about it.
     */
    private Shipment informAboutNewShipment(ShipmentRequest shipmentRequest) {
        return getShipmentDetails(shipmentRequest);
    }


    /*
    Method which returns mocked info about shipment details (should be provided by external company service(endpoint)).
     */
    private Shipment getShipmentDetails(ShipmentRequest shipmentRequest) {
        return new Shipment("Fake Company Name Ltd.", shipmentRequest.getMethodName(), 15.0,
                "http://www.fake-domain.com/fake/path/to/track/shipment",
                LocalDate.now());
    }

}
