package com.example.kafkaconnectexample.exception;

public class OrderNotFoundException extends RuntimeException{
    public static final String MESSAGE = "ORDER_NOT_FOUND";

    public OrderNotFoundException(){
        super(MESSAGE);
    }

}
