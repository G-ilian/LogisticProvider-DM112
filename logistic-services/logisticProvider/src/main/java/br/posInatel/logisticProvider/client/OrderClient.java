package br.posInatel.logisticProvider.client;

import br.posInatel.logisticProvider.model.Delivery;
import br.posInatel.logisticProvider.model.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
@Service
public class OrderClient {
    @Value("${delivery.rest.url}")
    private String deliveryUrl;

    private final String endpoint="orders";

    public void createOrders(Order order){
        String url = deliveryUrl+endpoint+"/createOrder";
        WebClient.create(url)
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(order), Order.class)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class) // Converter a resposta para uma String, se necessário
                .subscribe( // Adicionando uma assinatura para executar a solicitação HTTP
                        response -> System.out.println("Sucesso ao criar a entrega!"),
                        error -> System.err.println("Erro ao criar a entrega: " + error.getMessage())
                );
    }

    public Order getOrder(long numberOfOrder){
        String url = deliveryUrl+endpoint+"/getOrderByNumber/"+numberOfOrder;

        return WebClient.create(url)
                .get()
                .retrieve()
                .bodyToMono(Order.class)
                .block();

    }

    public List<Order> getAllOrders(){
        String url = deliveryUrl+endpoint+"/getAllOrders";

        return WebClient.create(url)
                .get()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(Order.class)
                .collectList()
                .log()
                .block();
    }

    public String getDeliveryUrl() {
        return deliveryUrl;
    }

    public void setDeliveryUrl(String deliveryUrl) {
        this.deliveryUrl = deliveryUrl;
    }
}
