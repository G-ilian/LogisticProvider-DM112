package br.posInatel.entregador.model;

import java.util.Date;

public class Order {
    private long orderNumber;
    private Date orderDate;
    private String clientCpf;
    private String clientName;
    private String clientEmail;
    private int status;

    public Order() {
    }

    public Order(long orderNumber, Date orderDate, String clientCpf, String clientName, String clientEmail,int status) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.clientCpf = clientCpf;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.status=status;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderDate=" + orderDate +
                ", clientCpf='" + clientCpf + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                '}';
    }
}
