package br.posInatel.entregador.model.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Pedidos")
public class OrderEntity {
    @Id
    @Column(name="numeroPedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderNumber;

    @Column(name="clienteEmail")
    private String  clientEmail;

    @Column(name="clienteCpf")
    private String  clientCpf;

    @Column(name="clienteName")
    private String  clientName;

    @Column(name="dataPedido")
    private Date orderDate;

    @Column(name="statusEntrega")
    private int status;


    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private DeliveryOrderEntity deliveryOrder;


    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public DeliveryOrderEntity getDeliveryOrder() {
        return deliveryOrder;
    }

    public void setDeliveryOrder(DeliveryOrderEntity deliveryOrder) {
        this.deliveryOrder = deliveryOrder;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
