package de.michlb.sample.rabbit.message.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.michlb.sample.rabbit.domain.MessageLog;
import de.michlb.sample.rabbit.domain.Product;
import de.michlb.sample.rabbit.repositories.MessageLogRepository;
import de.michlb.sample.rabbit.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 12.11.16.
 */
@Component
public class ProductMessageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductMessageController.class);

    @Autowired
    private ProductRepository productRepository = null;

    @Autowired
    private ObjectMapper objectMapper = null;

    @Autowired
    private MessageLogRepository messageLogRepository = null;

    @RabbitListener(queues = "product-queue")
    public void receiveProduct(String productString) {
        LOGGER.info(String.format("received Product [%s]", productString));
        messageLogRepository.save(new MessageLog("product-queue", productString));

        try {
            Product newProduct = objectMapper.readValue(productString, Product.class);
            productRepository.save(newProduct);
        } catch (Exception e) {
            LOGGER.error("could not read Product from message", e);
        }
    }
}
