package br.posInatel.logisticProvider.services;

import br.posInatel.logisticProvider.client.DeliveryClient;
import br.posInatel.logisticProvider.client.EmailClient;
import br.posInatel.logisticProvider.client.OrderClient;
import br.posInatel.logisticProvider.model.Delivery;
import br.posInatel.logisticProvider.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryClient deliveryClient;

    @Autowired
    private EmailClient emailClient;

    @Autowired
    private OrderClient orderClient;

    // Methods

    public List<Order> getAllOrders(){
        List<Order> productsRegistered = new ArrayList<>();
        try {
            productsRegistered = this.orderClient.getAllOrders();
        } catch (Exception e) {
            System.out.println(e);
        }
        return productsRegistered;
    }


    public List<Delivery> getAllDeliveredOrders(){
        List<Delivery> deliveries = new ArrayList<>();
        try {
            deliveries = this.deliveryClient.getAllDeliverys();
        } catch (Exception e) {
            System.out.println(e);
        }
        return deliveries;
    }

    public void createDeliveredOrder(Delivery delivery){
        try{
            deliveryClient.registerDelivery(delivery);
        }catch (Exception e){
            System.out.println(e);
        }

        try{
            Order order = orderClient.getOrder(delivery.getOrderNumber());
            String content ="Olá, "+order.getClientName() +
                    ",a entrega de seu pedido " +delivery.getOrderNumber()+
                    " Foi concluída. A recepeção do produto foi feita por "+
                    delivery.getReceiverName()+" documento: "+delivery.getReceiverCpf();

            emailClient.callSendMailService(delivery.getOrderNumber(), content,order.getClientEmail());
        }catch (Exception e){
            System.out.println(e);
        }
    }


    private Delivery getDelivery(int numberOfOrder){
        if(numberOfOrder<=0){
            System.out.println("Número do pedido é obrigatório!");
        }

        Delivery delivery = null;

        try{
            delivery = deliveryClient.getDelivery(numberOfOrder);
        } catch (Exception e) {
            String msg = "Pedido " + numberOfOrder + " não encontrado.";

        }

        return delivery;
    }


}
