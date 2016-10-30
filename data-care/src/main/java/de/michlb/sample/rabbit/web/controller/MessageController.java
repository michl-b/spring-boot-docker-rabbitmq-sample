package de.michlb.sample.rabbit.web.controller;

import de.michlb.sample.rabbit.service.MessageService;
import de.michlb.sample.rabbit.web.bean.MessageForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by admin on 29.10.16.
 */
@Controller
public class MessageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService = null;

    @GetMapping("/message")
    public String show(Model model) {

        model.addAttribute("messageForm", new MessageForm());

        return "message";
    }

    @PostMapping("/message")
    public String sendMessage(@ModelAttribute MessageForm messageForm, Model model) {
        LOGGER.error(String.format("received MessageForm: [%s]", messageForm.toString()));

        messageService.sendQueueMessage(messageForm.getMessage());

        model.addAttribute("messageForm", messageForm);
        return "message";
    }
}
