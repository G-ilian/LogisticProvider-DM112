package br.posInatel.entregador.rest;

import br.posInatel.entregador.interfaces.OrderInterface;
import br.posInatel.entregador.model.Order;
import br.posInatel.entregador.model.entities.OrderEntity;
import br.posInatel.entregador.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderRest implements OrderInterface {
    @Autowired
    private OrderService service;

    @Override
    @PostMapping("orders/createOrder")
    @ResponseBody
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }

    @Override
    @GetMapping("orders/getAllOrders")
    @ResponseBody
    public List<Order> getAllOrders() {

        return service.getAllOrders();
    }


    @Override
    @PostMapping("orders/getOrder")
    @ResponseBody
    public Order getOrder(@RequestBody OrderEntity orderEntity) {
        return service.getOrder(orderEntity);
    }


    @Override
    @GetMapping("orders/getOrderByNumber/{orderNumber}")
    @ResponseBody
    public OrderEntity getOrderByNumber(@PathVariable("orderNumber") long orderNumber) {
        return service.getOrderByNumber(orderNumber);
    }

    @Override
    @PutMapping("orders/updateOrder/{orderNumber}")
    public void updateOrder(@RequestBody Order order, @PathVariable("orderNumber") long orderNumber) {
        service.updateOrder(order,orderNumber);
    }
}
