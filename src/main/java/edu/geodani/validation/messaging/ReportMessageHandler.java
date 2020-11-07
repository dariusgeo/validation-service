package edu.geodani.validation.messaging;


import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import edu.geodani.validation.dto.ReportDTO;

@Component
@Deprecated
public class ReportMessageHandler {

    private final Logger logger = LoggerFactory.getLogger(ReportMessageHandler.class.getName());

    public void handleMessage(String message) {
        logger.info(String.format("Received new message :: %s ", message));
        ReportDTO reportDTO = new Gson().fromJson(message, ReportDTO.class);
        logger.info(String.format("Received a new created report :: %s ", reportDTO.toString()));
    }
}
