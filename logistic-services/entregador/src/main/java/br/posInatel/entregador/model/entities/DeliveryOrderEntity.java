package br.posInatel.entregador.model.entities;

import br.posInatel.entregador.model.DeliveryOrder;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Entregas")
public class DeliveryOrderEntity {
    @Id
    @Column(name="numeroPedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderNumber;

    @Column(name="status")
    private int status;
    @Column(name="dataPedido",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Column(name="dataEntrega",nullable = true)
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;


    @Column(name="receiver_id")
    private String receiverCpf;

    @Column(name="receiver_name")
    private String receiverName;


    @Column(name="client_id")
    private String clientCpf;

    @Column(name="client_name")
    private String clientName;

    public DeliveryOrderEntity() {
        this.status = DeliveryOrder.STATUS.CONFIRMED.ordinal();
    }


    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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

    public void setReceiverCpf(String receiverCpf) {
        this.receiverCpf = receiverCpf;
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
}
