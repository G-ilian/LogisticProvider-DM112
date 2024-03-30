package br.posInatel.entregador.client;

import br.posInatel.entregador.model.Order;
import br.posInatel.entregador.model.entities.OrderEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class InternalClient {

    @Value("${order.rest.url}")
    private String restUrl;

    private String endpoint="orders";

    public OrderEntity getOrderByNumber(long orderNumber){

        String url = restUrl+endpoint+"/getOrderByNumber/"+orderNumber;

        return WebClient.create(url)
                .get()
                .retrieve()
                .bodyToMono(OrderEntity.class)
                .block();
    }

    public void updateOrder(Order order,long orderNumber){
        String url = restUrl+endpoint+"/updateOrder/"+orderNumber;

        WebClient.create(url)
                .put()
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(order), Order.class)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
    }

    public Order getOrder(OrderEntity orderEntity) {
        String url = restUrl + endpoint + "/getOrder";

        return WebClient.create()
                .post()
                .uri(url)
                .body(Mono.just(orderEntity), OrderEntity.class)
                .retrieve()
                .bodyToMono(Order.class)
                .block();
    }
}
