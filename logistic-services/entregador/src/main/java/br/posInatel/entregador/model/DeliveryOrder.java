package br.posInatel.entregador.model;

import java.util.Date;

public class DeliveryOrder {
    private long idEntrega;
    private String receiverCpf;
    private String receiverName;
    private Date deliveryDate;
    private long orderNumber;

    public DeliveryOrder() {
    }

    public DeliveryOrder(long idEntrega, String receiverCpf, String receiverName, Date deliveryDate,long orderNumber) {
        this.idEntrega = idEntrega;
        this.receiverCpf = receiverCpf;
        this.receiverName = receiverName;
        this.deliveryDate = deliveryDate;
        this.orderNumber=orderNumber;
    }

    public long getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(long idEntrega) {
        this.idEntrega = idEntrega;
    }

    public String getReceiverCpf() {
        return receiverCpf;
    }

    public void setReceiverCpf(String receiverCpf) {
        this.receiverCpf = receiverCpf;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "DeliveryOrder{" +
                "idEntrega=" + idEntrega +
                ", receiverCpf='" + receiverCpf + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", orderNumber=" + orderNumber +
                '}';
    }
}
