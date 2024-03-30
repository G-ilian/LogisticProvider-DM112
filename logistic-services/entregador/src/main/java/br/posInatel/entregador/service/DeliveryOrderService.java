package br.posInatel.entregador.service;


import br.posInatel.entregador.client.InternalClient;
import br.posInatel.entregador.model.DeliveryOrder;
import br.posInatel.entregador.model.Order;
import br.posInatel.entregador.model.dao.DeliveryOrderRepository;
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
public class DeliveryOrderService  {
    @Autowired
    private DeliveryOrderRepository repo;

    @Autowired
    private InternalClient orderClient;


    public List<DeliveryOrder> getAllDeliveredOrders(){
        List<DeliveryOrderEntity> entities = repo.findAll();
        List<DeliveryOrder> orders = new ArrayList<>();

        for (DeliveryOrderEntity entity : entities) {
            DeliveryOrder deliveryOrder = convertToDeliveryOrder(entity);
            orders.add(deliveryOrder);
        }
        return orders;
    }

    public DeliveryOrderEntity getDeliveryByNumber(long orderNumber){
        Optional<DeliveryOrderEntity> obj = repo.findById((int)orderNumber);
        return obj.orElseThrow(() -> new DeliveryNotFoundException("Order " + orderNumber + " not found."));
    }



    public ResponseEntity<String> createDeliveryOrder(DeliveryOrder deliveryOrder){
        if (!existsOrder(deliveryOrder.getOrderNumber())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order doesn't exist.");
        }
        DeliveryOrderEntity entity = convertToEntity(deliveryOrder,orderClient);
        System.out.println("Create delivery");

        repo.save(entity);

        Order order = orderClient.getOrder(entity.getOrder());
        order.setStatus(1);
        orderClient.updateOrder(order, order.getOrderNumber());


        return ResponseEntity.ok("Delivery created sucessfuly!");
    }

    public void updateDeliveryOrder(DeliveryOrder delivery, long orderNumber){
            if(existsOrder(orderNumber)){
                DeliveryOrderEntity DeliveryEntity = getDeliveryByNumber(orderNumber);
                DeliveryEntity.setDeliveryDate(delivery.getDeliveryDate());
                DeliveryEntity.setReceiverCpf(delivery.getReceiverCpf());
                DeliveryEntity.setReceiverName(delivery.getReceiverName());
                repo.save(DeliveryEntity);

                System.out.println("O registro da entrega para o pedido "+orderNumber+" foi atualizado com sucesso!!!");
            }
    }

    public static DeliveryOrder  convertToDeliveryOrder (DeliveryOrderEntity entity){
        DeliveryOrder deliveryOrder = new DeliveryOrder(entity.getIdEntrega(),
                entity.getReceiverCpf(),
                entity.getReceiverName(),
                entity.getDeliveryDate(),
                entity.getOrder().getOrderNumber());

        return deliveryOrder;
    }

    public static DeliveryOrderEntity convertToEntity(DeliveryOrder deliveryOrder,InternalClient orderClient){
        DeliveryOrderEntity entity = new DeliveryOrderEntity();
        entity.setReceiverCpf(deliveryOrder.getReceiverCpf());
        entity.setDeliveryDate(deliveryOrder.getDeliveryDate());
        entity.setReceiverName(deliveryOrder.getReceiverName());

        OrderEntity order = orderClient.getOrderByNumber(deliveryOrder.getOrderNumber());

        entity.setOrder(order);

        return entity;
    }

    private boolean existsOrder(long orderNumber){

        try{
            OrderEntity order = orderClient.getOrderByNumber(orderNumber);
            return true;
        }catch (Exception e){
            return false;
        }

    }


}
