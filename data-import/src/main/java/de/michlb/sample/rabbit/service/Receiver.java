package de.michlb.sample.rabbit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * Created by admin on 28.10.16.
 */
public class Receiver {
    private static final Logger log = LoggerFactory.getLogger(Receiver.class);
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        String logMsg = "Received <" + message + ">";
        System.out.println(logMsg);
        log.info(logMsg);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
