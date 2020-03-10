package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.model.Product;
import br.com.milvusartis.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/create-product")
    public Product save(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/find-product/list")
    public List<Product> find(){
        return productRepository.findAll();
    }
}
