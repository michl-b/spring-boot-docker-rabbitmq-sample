package de.michlb.sample.rabbit.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.michlb.sample.rabbit.web.bean.ProductForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for handling rabbit queue communication
 *
 * @author Michael Bartsch
 */
@Service
public class ProductMessageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductMessageService.class);

    @Autowired
    private ObjectMapper objectMapper = null;

    @Autowired
    private MessageService messageService = null;

    /**
     * convert product to json and send it to product-queue
     * @param product ProductForm object to send
     * @return true if success, otherwise false
     * @throws JsonProcessingException when error occurs in amqp process
     */
    public boolean sendQueueMessage(ProductForm product) throws JsonProcessingException {
        String queueName = "product-queue";

        String jsonMessage = objectMapper.writeValueAsString(product);

        return messageService.sendQueueMessage(queueName, jsonMessage);
    }
}
