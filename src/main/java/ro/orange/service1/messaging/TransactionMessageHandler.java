package ro.orange.service1.messaging;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.orange.service1.dto.TransactionDTO;

@Component
public class TransactionMessageHandler {

    private final Logger logger = LoggerFactory.getLogger(ReportMessageHandler.class.getName());

    public void handleMessage(String message) {
        logger.info(String.format("Received new message :: %s ", message));
        TransactionDTO transactionDTO = new Gson().fromJson(message, TransactionDTO.class);
       logger.info(String.format("Received a new created transaction :: %s ", transactionDTO.toString()));
    }
}