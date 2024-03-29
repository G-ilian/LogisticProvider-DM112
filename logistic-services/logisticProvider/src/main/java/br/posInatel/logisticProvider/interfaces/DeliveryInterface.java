package br.posInatel.logisticProvider.interfaces;

import br.posInatel.logisticProvider.model.Delivery;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface DeliveryInterface {
    public List<Delivery> getAllOrders();
    public List<Delivery> getAllDeliveredOrders();
    public void createDeliveredOrder(long numberOfOrder);




}
