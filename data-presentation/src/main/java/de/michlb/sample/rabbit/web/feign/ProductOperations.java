package de.michlb.sample.rabbit.web.feign;

import de.michlb.sample.rabbit.dto.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by admin on 12.11.16.
 */
@FeignClient("data-backend")
public interface ProductOperations {

    @RequestMapping("/api/product/list")
    public List<Product> getList();
}
