package de.michlb.sample.rabbit.web.bean;

import lombok.Data;

/**
 * Form definition Bean for product input view
 *
 * @author Michael Bartsch
 */
@Data
public class ProductForm {
    private String name;
    private String pictureUrl;
    private Double price;
}
