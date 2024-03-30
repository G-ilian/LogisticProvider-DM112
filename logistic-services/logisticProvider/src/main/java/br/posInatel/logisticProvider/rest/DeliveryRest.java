package br.posInatel.logisticProvider.rest;

import br.posInatel.logisticProvider.interfaces.DeliveryInterface;
import br.posInatel.logisticProvider.model.Delivery;
import br.posInatel.logisticProvider.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeliveryRest implements DeliveryInterface {

    @Autowired
    private DeliveryService service;

    @Override
    @GetMapping("/getAllOrders")
    public List<Delivery> getAllOrders() {
        return service.getAllOrders();
    }

    @Override
    @GetMapping("/getAllDeliveredOrders")
    public List<Delivery> getAllDeliveredOrders() {
        return service.getAllDeliveredOrders();
    }

    @Override
    @PutMapping("/registerDeliveredOrder")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createDeliveredOrder(@RequestBody Delivery delivery) {
        service.createDeliveredOrder(delivery.getOrderNumber(), delivery.getReceiverCpf(), delivery.getReceiverName());
    }

}
