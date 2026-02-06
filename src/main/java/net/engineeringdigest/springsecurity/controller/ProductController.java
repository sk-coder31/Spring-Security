package net.engineeringdigest.springsecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {
    private record Product(int id, String name, String description) {

    }

    List<Product>productList = new ArrayList<>(List.of(new Product(1,"Iphone"
    ,"IPhone for Apple"),new Product(2,"Ipad","Ipad for Apple")));

    @GetMapping
    public List<Product> getProducts() {
        return productList;
    }
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        productList.add(product);
        return product;
    }
    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        CsrfToken token =  (CsrfToken) request.getAttribute("_csrf");
        return token;
    }

}
