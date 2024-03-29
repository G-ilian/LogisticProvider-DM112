package br.posInatel.logisticProvider.services;

import br.posInatel.logisticProvider.client.DeliveryClient;
import br.posInatel.logisticProvider.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryClient deliveryClient;

    // Methods

    public List<Delivery> getAllOrders(){
        List<Delivery> deliveries = new ArrayList<>();
        try {
            deliveries = this.deliveryClient.getAllDeliverys();
        } catch (Exception e) {
            System.out.println(e);
        }
        return deliveries;
    }


    public List<Delivery> getAllDeliveredOrders(){
        return null;
    }

    public void createDeliveredOrder(){

    }


}
