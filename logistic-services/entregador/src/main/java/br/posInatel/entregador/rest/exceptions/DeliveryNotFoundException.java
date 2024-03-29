package br.posInatel.entregador.rest.exceptions;

public class DeliveryNotFoundException extends RuntimeException{
    public DeliveryNotFoundException() {
    }

    public DeliveryNotFoundException(String message) {
        super(message);
    }

    public DeliveryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeliveryNotFoundException(Throwable cause) {
        super(cause);
    }

    public DeliveryNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
