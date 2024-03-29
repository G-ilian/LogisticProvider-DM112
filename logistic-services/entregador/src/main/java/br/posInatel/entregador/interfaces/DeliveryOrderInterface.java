package br.posInatel.entregador.interfaces;

import br.posInatel.entregador.model.DeliveryOrder;

import java.util.List;

public interface DeliveryOrderInterface {

    // Retrieve
    List<DeliveryOrder> getAllOrders(); // OK
    List<DeliveryOrder> getAllDeliveredOrders();

    DeliveryOrder getOrderByNumber(long orderNumber); // OK

    // Create
    void createDeliveryOrder(DeliveryOrder delivery); // OK

    // Update
    void updateDeliveryOrder(DeliveryOrder delivery, long orderNumber);


}
