package br.posInatel.logisticProvider.client;

import br.posInatel.logisticProvider.model.MailRequestData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EmailClient {
    @Value("${email.rest.url}")
    private String emailRestUrl;

    @Value("${email.sender}")
    private String sendFromAddress;

    @Value("${email.password}")
    private String sendPassAddress;

    private String mailEndpoint="/sendEmail";

    public void callSendMailService(int orderNumber, String content,String sendToAddress) {

        String url = emailRestUrl + mailEndpoint ;
        System.out.println("URL: " + url);

        MailRequestData mrd = new MailRequestData(orderNumber, sendFromAddress, sendPassAddress, sendToAddress, content);

        WebClient
                .create(url)
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(mrd), MailRequestData.class)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class).defaultIfEmpty("")
                .log()
                .block();
    }

}
