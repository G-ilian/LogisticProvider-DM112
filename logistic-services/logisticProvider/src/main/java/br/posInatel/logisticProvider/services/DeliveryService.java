package br.posInatel.logisticProvider.services;

import br.posInatel.logisticProvider.client.DeliveryClient;
import br.posInatel.logisticProvider.client.EmailClient;
import br.posInatel.logisticProvider.model.Delivery;
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

    // Methods

    public List<Delivery> getAllOrders(){
        List<Delivery> productsRegistered = new ArrayList<>();
        try {
            productsRegistered = this.deliveryClient.getAllProducts();
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

    public void createDeliveredOrder(int numberOfOrder,String receiverCpf,String receiverName){

        Delivery delivery = getDelivery(numberOfOrder);
        // Date of delivery
        delivery.setDeliveryDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        // Receiver infos
        delivery.setReceiverCpf(receiverCpf);
        delivery.setReceiverName(receiverName);

        try{
            deliveryClient.registerDelivery(delivery);
        }catch (Exception e){
            System.out.println(e);
        }

        try{
            String content ="Olá, Gabriel..." +
                    "A entrega de seu pedido " +delivery.getOrderNumber()+
                    "Foi concluída. A recepeção do produto foi feita por "+
                    delivery.getReceiverName()+" no CPF: "+delivery.getReceiverCpf();
            emailClient.callSendMailService(numberOfOrder,content);
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
