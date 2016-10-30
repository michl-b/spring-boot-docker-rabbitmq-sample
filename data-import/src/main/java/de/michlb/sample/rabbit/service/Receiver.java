package de.michlb.sample.rabbit.service;

import de.michlb.sample.rabbit.domain.MessageLog;
import de.michlb.sample.rabbit.repositories.MessageLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * Created by admin on 28.10.16.
 */
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private MessageLogRepository messageLogRepository = null;

    public void receiveMessage(String message) {
        String logMsg = "Received <" + message + ">";
        System.out.println(logMsg);
        LOGGER.info(logMsg);
        messageLogRepository.save(new MessageLog(message));
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
