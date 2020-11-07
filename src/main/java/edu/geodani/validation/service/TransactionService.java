package edu.geodani.validation.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import edu.geodani.validation.config.RabbitMQProperties;
import edu.geodani.validation.dto.TransactionDTO;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionService {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMQProperties rabbitMQProperties;

    public void createTransaction(TransactionDTO transactionDTO) {
        String messageToSend = new Gson().toJson(transactionDTO);
        log.debug(String.format("Sending message to transaction queue... %s ", messageToSend));
        rabbitTemplate.convertAndSend(rabbitMQProperties.getTxOutgoingExchangeName(), rabbitMQProperties.getTxOutgoingRoutingKey(), messageToSend);
    }
}
