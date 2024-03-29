package br.posInatel.logisticProvider.model;

import java.util.Date;


public class Delivery {
    private long orderNumber;

    public static enum orderStatus {DELIVERED , PENDING};
    private Date dateOrder;
    private Date dateDelivered;


    public Delivery(int orderNumber, Date dateOrder, Date dateDelivered) {
        this.orderNumber = orderNumber;
        this.dateOrder = dateOrder;
        this.dateDelivered = dateDelivered;
    }

    public Delivery() {
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "orderNumber=" + orderNumber +
                ", dateOrder=" + dateOrder +
                ", dateDelivered=" + dateDelivered +
                '}';
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Date getDateDelivered() {
        return dateDelivered;
    }

    public void setDateDelivered(Date dateDelivered) {
        this.dateDelivered = dateDelivered;
    }
}
