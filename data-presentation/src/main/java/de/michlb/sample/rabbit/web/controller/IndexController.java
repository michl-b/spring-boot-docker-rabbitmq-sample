package de.michlb.sample.rabbit.web.controller;

import de.michlb.sample.rabbit.dto.Product;
import de.michlb.sample.rabbit.web.feign.ProductOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Michael Bartsch
 */
@Controller
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ProductOperations productOperations;

    @GetMapping("/")
    public String show(Model model) {
        List<Product> productList = productOperations.getList();
        model.addAttribute("products", productList);
        return "index";
    }
}
