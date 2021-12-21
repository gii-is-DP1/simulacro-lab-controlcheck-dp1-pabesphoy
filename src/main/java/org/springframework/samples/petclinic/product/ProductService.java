package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        List<Product> res = productRepository.findAll();
        System.out.println("Numero de productos: " + res.size());
        return res;
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return productRepository.findProductTypeByName(typeName).orElse(null);
    }

    public Product save(Product p){
        return null;       
    }

    public Object getAllProductTypes() {
        return productRepository.findAllProductTypes();
    }

    
}
