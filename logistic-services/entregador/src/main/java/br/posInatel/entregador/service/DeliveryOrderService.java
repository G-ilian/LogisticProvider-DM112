package br.posInatel.entregador.service;


import br.posInatel.entregador.model.DeliveryOrder;
import br.posInatel.entregador.model.dao.DeliveryOrderRepository;
import br.posInatel.entregador.model.entities.DeliveryOrderEntity;
import br.posInatel.entregador.rest.exceptions.DeliveryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryOrderService  {
    @Autowired
    private DeliveryOrderRepository repo;

    public List<DeliveryOrder> getAllOrders(){
        List<DeliveryOrderEntity> entities = repo.findAll();
        List<DeliveryOrder> orders = new ArrayList<>();

        for (DeliveryOrderEntity entity : entities) {
            DeliveryOrder deliveryOrder = convertToDeliveryOrder(entity);
            orders.add(deliveryOrder);
        }
        return orders;
    }

    public List<DeliveryOrder> getAllDeliveredOrders(){
        List<DeliveryOrderEntity> entities = repo.findByStatus(1);
        List<DeliveryOrder> orders = new ArrayList<>();

        for (DeliveryOrderEntity entity : entities) {
            DeliveryOrder deliveryOrder = convertToDeliveryOrder(entity);
            orders.add(deliveryOrder);
        }
        return orders;
    }

    public DeliveryOrderEntity getOrderByNumber(long orderNumber){
        Optional<DeliveryOrderEntity> obj = repo.findById((int)orderNumber);
        return obj.orElseThrow(() -> new DeliveryNotFoundException("Order " + orderNumber + " not found."));
    }

    public void createDeliveryOrder(DeliveryOrder deliveryOrder){
        DeliveryOrderEntity entity = convertToEntity(deliveryOrder);
        System.out.println("Create delivery");
        repo.save(entity);
    }

    public void updateDeliveryOrder(DeliveryOrder delivery, long orderNumber){
        DeliveryOrderEntity entity = getOrderByNumber(orderNumber);
        entity.setOrderNumber(delivery.getOrderNumber());
        entity.setDeliveryDate(delivery.getDeliveryDate());
        entity.setOrderDate(delivery.getOrderDate());
        entity.setClientCpf(delivery.getClientCpf());
        entity.setClientName(delivery.getClientName());
        entity.setReceiverCpf(delivery.getReceiverCpf());
        entity.setReceiverName(delivery.getReceiverName());

        repo.save(entity);

        System.out.println("O registro da entrega para o pedido "+orderNumber+" foi atualizado com sucesso!!!");
    }

    public static DeliveryOrder  convertToDeliveryOrder (DeliveryOrderEntity entity){
        DeliveryOrder deliveryOrder = new DeliveryOrder(entity.getOrderNumber(),
                entity.getReceiverCpf(),
                entity.getReceiverName(),
                entity.getClientCpf(),
                entity.getClientName(),
                entity.getDeliveryDate(),
                entity.getOrderDate());

        return deliveryOrder;
    }

    public static DeliveryOrderEntity convertToEntity(DeliveryOrder deliveryOrder){
        DeliveryOrderEntity entity = new DeliveryOrderEntity();
        entity.setClientCpf(deliveryOrder.getClientCpf());
        entity.setReceiverCpf(deliveryOrder.getReceiverCpf());
        entity.setDeliveryDate(deliveryOrder.getDeliveryDate());
        entity.setOrderDate(deliveryOrder.getOrderDate());
        entity.setClientName(deliveryOrder.getClientName());
        entity.setReceiverName(deliveryOrder.getReceiverName());
        entity.setOrderNumber(deliveryOrder.getOrderNumber());

        return entity;
    }




}
