package br.posInatel.emailService.model;

import java.util.Arrays;

public class MailRequestData {
    private long orderNumber;
    private String sender;
    private String password;
    private String to;

    private String content;

    public MailRequestData() {
    }

    public MailRequestData(long orderNumber, String sender, String password, String to, String content) {
        this.orderNumber = orderNumber;
        this.sender = sender;
        this.password = password;
        this.to = to;
        this.content = content;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MailRequestData{" +
                "orderNumber=" + orderNumber +
                ", sender='" + sender + '\'' +
                ", password='" + password + '\'' +
                ", to='" + to + '\'' +
                ", content=" + content +
                '}';
    }
}
