package br.posInatel.entregador.rest;

import br.posInatel.entregador.interfaces.DeliveryOrderInterface;
import br.posInatel.entregador.model.DeliveryOrder;
import br.posInatel.entregador.service.DeliveryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeliveryOrderRest implements DeliveryOrderInterface {

    @Autowired
    private DeliveryOrderService serviceOrder;


    @Override
    @GetMapping("deliveryOrders/getAllOrders")
    @ResponseBody
    public List<DeliveryOrder> getAllOrders() {
        return serviceOrder.getAllOrders();
    }

    @Override
    @GetMapping("deliveryOrders/getAllDeliveredOrders")
    public List<DeliveryOrder> getAllDeliveredOrders() {
        return serviceOrder.getAllDeliveredOrders();
    }

    @Override
    @GetMapping("deliveryOrders/getOrderByNumber/{orderNumber}")
    @ResponseBody
    public DeliveryOrder getOrderByNumber(@PathVariable("orderNumber") long orderNumber) {
        return serviceOrder.convertToDeliveryOrder(serviceOrder.getOrderByNumber(orderNumber));
    }

    @Override
    @PostMapping("deliveryOrders/createDelivery")
    @ResponseBody
    public ResponseEntity<String> createDeliveryOrder(@RequestBody DeliveryOrder delivery) {
        return serviceOrder.createDeliveryOrder(delivery);
    }

    @Override
    @PutMapping("deliveryOrders/updateDeliveryRegister/{orderNumber}")
    public void updateDeliveryOrder(@RequestBody DeliveryOrder delivery,@PathVariable("orderNumber") long orderNumber) {
        serviceOrder.updateDeliveryOrder(delivery,orderNumber);
    }
}
