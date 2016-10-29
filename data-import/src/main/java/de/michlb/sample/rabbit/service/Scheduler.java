package de.michlb.sample.rabbit.service;

import de.michlb.sample.rabbit.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 28.10.16.
 */
@Component
public class Scheduler {
    private static final Logger log = LoggerFactory.getLogger(Scheduler.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }


    @Autowired
    private RabbitTemplate rabbitTemplate = null;
/*
    @Scheduled(fixedDelay = 1000L)
    public void send() {
        String message = "Wohooo!";
        String queueName = RabbitConfig.queueName;
        this.rabbitTemplate.convertAndSend ( queueName, message );
    }
*/
}
