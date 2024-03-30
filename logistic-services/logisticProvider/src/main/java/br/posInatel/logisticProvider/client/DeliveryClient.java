package br.posInatel.logisticProvider.client;

import br.posInatel.logisticProvider.model.Delivery;
import org.springframework.beans.factory.annotation.Value;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DeliveryClient {

    @Value("${delivery.rest.url}")
    private String deliveryUrl;

    private final String endpoint="deliveryOrders";

    public void registerDelivery(Delivery delivery) {
        String url = deliveryUrl + endpoint + "/createDelivery";
        WebClient.create(url)
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(delivery), Delivery.class)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class) // Converter a resposta para uma String, se necessário
                .subscribe( // Adicionando uma assinatura para executar a solicitação HTTP
                        response -> System.out.println("Sucesso ao criar a entrega!"),
                        error -> System.err.println("Erro ao criar a entrega: " + error.getMessage())
                );
    }

    public List<Delivery> getAllProducts(){
        String url = deliveryUrl+endpoint+"/getAllOrders";

        return WebClient.create(url).
                get().
                header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).
                retrieve().
                bodyToFlux(Delivery.class).collectList().log().block();
    }


    public List<Delivery> getAllDeliverys(){
        String url = deliveryUrl+endpoint+"/getAllDeliveredOrders";

        return WebClient.create(url).
                get().
                header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).
                retrieve().
                bodyToFlux(Delivery.class).collectList().log().block();
    }

    public Delivery getDelivery(long orderNumber){
        String url = deliveryUrl+endpoint+"/getOrderByNumber/"+orderNumber;

        return WebClient.create(url)
                .get()
                .retrieve()
                .bodyToMono(Delivery.class)
                .block();
    }


}
