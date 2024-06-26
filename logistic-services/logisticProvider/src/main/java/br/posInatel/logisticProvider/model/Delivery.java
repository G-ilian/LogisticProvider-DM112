package br.posInatel.logisticProvider.model;

import java.util.Date;


public class Delivery {
    private int orderNumber;

    public static enum orderStatus {DELIVERED , PENDING};
    private Date deliveryDate;

    private String receiverCpf;
    private String receiverName;

    private Order order;


    public Delivery(int orderNumber, Date deliveryDate, String receiverCpf, String receiverName) {
        this.orderNumber = orderNumber;
        this.deliveryDate = deliveryDate;
        this.receiverCpf = receiverCpf;
        this.receiverName = receiverName;
    }

    public Delivery() {
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "orderNumber=" + orderNumber +
                ", dateDelivered=" + deliveryDate +
                '}';
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getReceiverCpf() {
        return receiverCpf;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverCpf(String receiverCpf) {
        this.receiverCpf = receiverCpf;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Order getOrder() {
        return order;
    }
}
