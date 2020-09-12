package ro.orange.service1.service;

import ro.orange.service1.config.RabbitMQProperties;
import ro.orange.service1.dto.TransactionDTO;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMQProperties rabbitMQProperties;

    public TransactionService(RabbitTemplate rabbitTemplate,
                              RabbitMQProperties rabbitMQProperties){
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitMQProperties = rabbitMQProperties;
    }

    public void createTransaction(TransactionDTO transactionDTO) {
        String messageToSend = new Gson().toJson(transactionDTO);
        logger.debug(String.format("Sending message to transaction queue... %s ", messageToSend));
        rabbitTemplate.convertAndSend(rabbitMQProperties.getTxOutgoingExchangeName(), rabbitMQProperties.getTxOutgoingRoutingKey(), messageToSend);
    }
}
