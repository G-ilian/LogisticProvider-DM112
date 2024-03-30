package br.posInatel.entregador.interfaces;

import br.posInatel.entregador.model.DeliveryOrder;
import br.posInatel.entregador.model.Order;
import br.posInatel.entregador.model.entities.OrderEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderInterface {
    // Create
    ResponseEntity<String> createOrder(Order order);
    // Retrieve
    List<Order> getAllOrders();

    Order getOrder(OrderEntity orderEntity);

    OrderEntity getOrderByNumber(long orderNumber);
    // Update
    void updateOrder(Order order,long orderNumber);
}
