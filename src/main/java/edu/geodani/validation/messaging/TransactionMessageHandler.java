package edu.geodani.validation.messaging;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import edu.geodani.validation.dto.TransactionDTO;

@Component
@Slf4j
public class TransactionMessageHandler {

    public void handleMessage(String message) {
       log.info(String.format("Received new message :: %s ", message));
       TransactionDTO transactionDTO = new Gson().fromJson(message, TransactionDTO.class);
       log.info(String.format("Received a new created transaction :: %s ", transactionDTO.toString()));
    }
}