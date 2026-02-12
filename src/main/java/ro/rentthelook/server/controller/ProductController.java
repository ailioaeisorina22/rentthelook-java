package ro.rentthelook.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.rentthelook.server.entity.Product;
import ro.rentthelook.server.repository.ProductRepository;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> getByCategory(@RequestParam String category){
        return productRepository.findByCategory(category);
    }

    //Ia valoarea din query parameter cu numele subcategory și o pune în variabila subcategory
    // /productsub?subcategory=shoes => subcategory = "shoes"
    @GetMapping("/productsub")
    public List<Product> getBySubcategory(@RequestParam String subcategory) { //same name as in url
        return productRepository.findBySubcategory(subcategory);
    }

    //PATH VARIABLE : /products/5 --> ID = 5
    //Response entity - to control http response - permite setare status, body, headers
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok) //if the product exists - it creates the http response
                .orElseGet(() -> ResponseEntity.notFound().build()); //if the product does not exists -> return 404 not found
    }
}
