package de.michlb.sample.rabbit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for handling rabbit queue communication
 *
 * @author Michael Bartsch
 */
@Service
public class MessageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate = null;

    /**
     * push message to the queue
     * @param queueName name of target queue
     * @param message message to be sent
     * @return true if successful, otherwise false
     */
    public boolean sendQueueMessage(String queueName, String message) {
        try {
            LOGGER.info(String.format("send message [%s] to queue [%s]", message, queueName));
            rabbitTemplate.convertAndSend(queueName, message);
            LOGGER.error("done!");
            return true;
        } catch (Exception e) {
            LOGGER.error("failed!", e);
            return false;
        }
    }
}
