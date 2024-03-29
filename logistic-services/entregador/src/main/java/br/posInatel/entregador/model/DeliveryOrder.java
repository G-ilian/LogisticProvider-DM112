package br.posInatel.entregador.model;

import java.util.Date;

public class DeliveryOrder {
    public enum STATUS {PENDING, CONFIRMED };
    private long orderNumber;
    private String receiverCpf;
    private String receiverName;
    private String clientCpf;
    private String clientName;
    private Date deliveryDate;
    private Date orderDate;

    public DeliveryOrder() {
    }


    public DeliveryOrder(long orderNumber, String receiverCpf, String receiverName, String clientCpf, String clientName, Date deliveryDate, Date orderDate) {
        this.orderNumber = orderNumber;
        this.receiverCpf = receiverCpf;
        this.receiverName = receiverName;
        this.clientCpf = clientCpf;
        this.clientName = clientName;
        this.deliveryDate = deliveryDate;
        this.orderDate = orderDate;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getReceiverCpf() {
        return receiverCpf;
    }

    public void setReceiverCpf(String receiverCpf) {
        this.receiverCpf = receiverCpf;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getClientCpf() {
        return clientCpf;
    }

    public void setClientCpf(String clientCpf) {
        this.clientCpf = clientCpf;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "OrderDelivery{" +
                "orderNumber=" + orderNumber +
                ", receiverCpf='" + receiverCpf + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", clientCpf='" + clientCpf + '\'' +
                ", clientName='" + clientName + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", orderDate=" + orderDate +
                '}';
    }
}
