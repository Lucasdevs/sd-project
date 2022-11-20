package com.example.consumer.service;

import com.example.consumer.service.model.Cardapio;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;

public class CardapioListener {

    @SqsListener(value = "http://localhost:4566/000000000000/sqs-cardapios")
    public void receiveMessageCreateUser(String message) throws JsonProcessingException {
        Cardapio cardapio = new ObjectMapper().readValue(message, Cardapio.class);
        System.out.println(cardapio);
    }
}
