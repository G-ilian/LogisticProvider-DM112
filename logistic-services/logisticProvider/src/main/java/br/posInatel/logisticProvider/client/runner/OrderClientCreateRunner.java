package br.posInatel.logisticProvider.client.runner;

import br.posInatel.logisticProvider.client.OrderClient;
import br.posInatel.logisticProvider.model.Order;

import java.util.Date;

public class OrderClientCreateRunner {
    public static void main(String[] args) {
        OrderClient client = new OrderClient();
        client.setDeliveryUrl(ClientUtil.getOrderUrl());

        Order order = new Order();

        order.setOrderDate(new Date());
        order.setStatus(0);
        order.setClientEmail("ilian.fon@gmail.com");
        order.setClientCpf("100.000.000-90");
        order.setClientName("Gabriel Fonseca");

       client.createOrders(order);
    }
}
