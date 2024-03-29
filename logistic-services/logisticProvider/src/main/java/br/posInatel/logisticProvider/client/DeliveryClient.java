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

    private final String endpoint="/deliverys";

    public void registerDelivery(Delivery delivery){
        String url = deliveryUrl+endpoint;

        WebClient.create(url)
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(delivery), Delivery.class)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
    }

    public List<Delivery> getAllDeliverys(){
        String url = deliveryUrl+endpoint;

        return WebClient.create(url).
                get().
                header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).
                retrieve().
                bodyToFlux(Delivery.class).collectList().log().block();
    }


}
