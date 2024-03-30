package br.posInatel.logisticProvider.interfaces;

import br.posInatel.logisticProvider.model.Delivery;
import br.posInatel.logisticProvider.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface DeliveryInterface {
    public List<Order> getAllOrders();
    public List<Delivery> getAllDeliveredOrders();
    public void createDeliveredOrder(Delivery delivery);




}
