package br.posInatel.entregador.service;

import br.posInatel.entregador.model.DeliveryOrder;
import br.posInatel.entregador.model.Order;
import br.posInatel.entregador.model.dao.OrderRepository;
import br.posInatel.entregador.model.entities.DeliveryOrderEntity;
import br.posInatel.entregador.model.entities.OrderEntity;
import br.posInatel.entregador.rest.exceptions.DeliveryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repo;

    public ResponseEntity<String> createOrder(Order order){
        OrderEntity entity = convertToEntity(order);
        System.out.println("Create Order");

        repo.save(entity);

        return ResponseEntity.ok("Delivery created sucessfuly!");
    }

    public List<Order> getAllOrders(){
        List<OrderEntity> entities = repo.findAll();

        List<Order> orders = new ArrayList<>();

        for (OrderEntity entity : entities) {
            Order deliveryOrder = convertToOrder(entity);

            orders.add(deliveryOrder);
        }
        return orders;
    }

    public void updateOrder(Order order, long orderNumber){
        OrderEntity entity = getOrderByNumber(orderNumber);

        entity.setOrderDate(order.getOrderDate());
        entity.setStatus(order.getStatus());
        entity.setOrderNumber(entity.getOrderNumber());
        entity.setClientEmail(entity.getClientEmail());
        entity.setClientName(entity.getClientName());
        entity.setClientCpf(entity.getClientCpf());

        repo.save(entity);
    }

    public Order getOrder(OrderEntity entity){
        return convertToOrder(entity);
    }

    public OrderEntity getOrderByNumber(long orderNumber){
        Optional<OrderEntity> obj = repo.findById((int)orderNumber);
        return obj.orElseThrow(() -> new DeliveryNotFoundException("Order " + orderNumber + " not found."));
    }

    public static Order  convertToOrder (OrderEntity entity){
        Order order = new Order(entity.getOrderNumber(),
                entity.getOrderDate(),
                entity.getClientCpf(),
                entity.getClientName(),
                entity.getClientEmail(),
                entity.getStatus()
        );

        return order;
    }

    public static OrderEntity convertToEntity(Order order){
        OrderEntity entity = new OrderEntity();

        entity.setOrderNumber(order.getOrderNumber());
        entity.setOrderDate(order.getOrderDate());
        entity.setClientCpf(order.getClientCpf());
        entity.setClientName(order.getClientName());
        entity.setClientEmail(order.getClientEmail());

        return entity;
    }
}
