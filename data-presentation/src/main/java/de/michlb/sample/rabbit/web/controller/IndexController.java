package de.michlb.sample.rabbit.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Michael Bartsch
 */
@Controller
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String show(Model model) {
        return "index";
    }
}
