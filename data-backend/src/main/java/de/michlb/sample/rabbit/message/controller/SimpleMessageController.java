package de.michlb.sample.rabbit.message.controller;

import de.michlb.sample.rabbit.domain.MessageLog;
import de.michlb.sample.rabbit.domain.Product;
import de.michlb.sample.rabbit.repositories.MessageLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 12.11.16.
 */
@Component
public class SimpleMessageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMessageController.class);

    @Autowired
    private MessageLogRepository messageLogRepository = null;

    @RabbitListener(queues = ("data-queue"))
    public void receiveProduct(String message ) {
        LOGGER.info( String.format("received simple message [%s]", message) );
        messageLogRepository.save(new MessageLog("data-queue", message));
    }
}
