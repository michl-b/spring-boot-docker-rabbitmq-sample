package de.michlb.sample.rabbit.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.michlb.sample.rabbit.service.ProductMessageService;
import de.michlb.sample.rabbit.web.bean.ProductForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Michael Bartsch
 */
@Controller
public class ProductCareController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCareController.class);

    @Autowired
    private ProductMessageService ProductMessageService = null;

    @GetMapping("/product")
    public String show(Model model) {

        model.addAttribute("productForm", new ProductForm());

        return "product";
    }

    @PostMapping("/product")
    public String sendMessage(@ModelAttribute ProductForm productForm, Model model) {
        LOGGER.error(String.format("received ProductForm: [%s]", productForm.toString()));

        try {
            ProductMessageService.sendQueueMessage(productForm);
        } catch (JsonProcessingException e) {
            model.addAttribute("error", "message could not be sent: " + e.getMessage());
            LOGGER.error("transfer of object failed", e);
        }

        model.addAttribute("productForm", productForm);
        return "product";
    }
}
