package br.posInatel.entregador.model.entities;

import br.posInatel.entregador.model.DeliveryOrder;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Entregas")
public class DeliveryOrderEntity {
    @Id
    @Column(name="idEntrega")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEntrega;

    @Column(name="dataEntrega",nullable = true)
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @Column(name="receiver_cpf")
    private String receiverCpf;

    @Column(name="receiver_name")
    private String receiverName;

    @OneToOne
    @JoinColumn(name = "orderNumber")
    private OrderEntity order;

    public long getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(long idEntrega) {
        this.idEntrega = idEntrega;
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

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
