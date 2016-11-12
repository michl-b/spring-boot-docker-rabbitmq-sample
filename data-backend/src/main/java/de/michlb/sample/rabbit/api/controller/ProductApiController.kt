package de.michlb.sample.rabbit.api.controller

import de.michlb.sample.rabbit.domain.Product
import de.michlb.sample.rabbit.repositories.MessageLogRepository
import de.michlb.sample.rabbit.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by admin on 12.11.16.
 */
@RestController
@RequestMapping("api/product/")
class ProductApiController {

    @Autowired
    lateinit var productRepository: ProductRepository


    @GetMapping("list")
    fun list() : List<Product> {
        return productRepository.findAll();
    }
}